package logistica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.commands.AgregarBarrilCommand;
import com.robin.logistica.commands.EnvasarBarrilCommand;
import com.robin.logistica.events.BarrilAgregado;
import com.robin.logistica.events.BarrilEnvasado;
import com.robin.logistica.events.LogisticaCreada;
import com.robin.logistica.values.*;
import com.robin.lote.values.LoteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnvasarBarrilUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    EnvasarBarrilUseCase useCase;


    @Test
    public void EnvasarBarrilTest(){
        //arrange
        LogisticaId logisticaId= LogisticaId.of("Logi2");
        BarrilId barrilId= BarrilId.of("22");
        LoteId loteId= LoteId.of("2020-1");
        var command= new EnvasarBarrilCommand(logisticaId, barrilId, loteId);
        when(repository.getEventsBy(command.getLogisticaId().value())).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (BarrilEnvasado)events.get(0);
        Assertions.assertEquals("22",barrilId.value());
    }
    private List<DomainEvent> history() {
        LoteId loteId= LoteId.of("2020-1");
        BarrilId barrilId= BarrilId.of("22");
        Capacidad capacidad= new Capacidad(60);
        TipoBarril tipoBarril= new TipoBarril("Euro conector G");
        Estado estado = new Estado("VACIO");


        return List.of(
                new LogisticaCreada(loteId),
                new BarrilAgregado(barrilId,capacidad,tipoBarril,estado)
        );}
}
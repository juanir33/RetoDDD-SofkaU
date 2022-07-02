package logistica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.commands.AgregarBarrilCommand;
import com.robin.logistica.events.BarrilAgregado;
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

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AgregarBarrilUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarBarrilUseCase useCase;

    @Test
    public void agregarBarrilTest(){
        //arrange
        LogisticaId logisticaId= LogisticaId.of("Logi2");
        BarrilId barrilId= BarrilId.of("22");
        Capacidad capacidad= new Capacidad(60);
        TipoBarril tipoBarril= new TipoBarril("Euro conector G");
        Estado estado = new Estado("VACIO");
        var command= new AgregarBarrilCommand(logisticaId, barrilId,capacidad,tipoBarril,estado);
        when(repository.getEventsBy(command.getLogisticaId().value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (BarrilAgregado)events.get(0);
        Assertions.assertEquals("VACIO", estado.value());
    }
    private List<DomainEvent> history() {
        LoteId loteId= LoteId.of("2020-1");


        return List.of(
                new LogisticaCreada(loteId)



        );}

}
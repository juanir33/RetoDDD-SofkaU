package logistica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.logistica.commands.CambiarAreaDeEncargadoCommand;
import com.robin.logistica.events.EncargadoAsignado;
import com.robin.logistica.events.EncargadoCambiadoDeArea;
import com.robin.logistica.events.LogisticaCreada;
import com.robin.logistica.values.Area;
import com.robin.logistica.values.EncargadoId;
import com.robin.logistica.values.LogisticaId;
import com.robin.lote.events.LoteCreado;
import com.robin.lote.events.TareaAgregada;
import com.robin.lote.values.*;
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
class CambiarAreaDeEncargadoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarAreaDeEncargadoUseCase useCase;

    @Test
    public void cambiarAreaEncargadoTest(){
        //arrange
        LogisticaId logisticaId= LogisticaId.of("Logi2");
        EncargadoId encargadoId= EncargadoId.of("Enc1");
        Area area= new Area("Embarrilado");
        var command= new CambiarAreaDeEncargadoCommand(logisticaId,encargadoId,area);
        when(repository.getEventsBy(command.getLogisticaId().value())).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EncargadoCambiadoDeArea)events.get(0);
        Assertions.assertEquals("Embarrilado", area.value());
    }
    private List<DomainEvent> history() {
        LoteId loteId= LoteId.of("2020-1");
        EncargadoId encargadoId= EncargadoId.of("32");
        Area area = new Area("LIMPIEZA");
        Nombre nombre= new Nombre("mario");

        return List.of(
                new LogisticaCreada(loteId),
                new EncargadoAsignado(encargadoId, nombre,area)


        );}
}
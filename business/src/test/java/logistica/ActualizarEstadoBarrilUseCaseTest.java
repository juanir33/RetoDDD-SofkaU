package logistica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.Logistica;
import com.robin.logistica.commands.EnvasarBarrilCommand;
import com.robin.logistica.events.BarrilAgregado;
import com.robin.logistica.events.BarrilEnvasado;
import com.robin.logistica.events.EstadoBarrilActualizado;
import com.robin.logistica.events.LogisticaCreada;
import com.robin.logistica.values.*;
import com.robin.lote.values.LoteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarEstadoBarrilUseCaseTest {


    @Mock
    private DomainEventRepository repository;
    @InjectMocks
    ActualizarEstadoBarrilUseCase useCase;

    @Test
    void ActualizarEstadoTest() {
        //arrange
        var logistId = LogisticaId.of("logi");
        var event = createTriggeredEventWith(logistId);
        when(repository.getEventsBy(logistId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(logistId.toString())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var estadoCambiado = (EstadoBarrilActualizado) events.get(0);
        Assertions.assertEquals("LLENO", estadoCambiado.getEstado().value());

    }

    private BarrilEnvasado createTriggeredEventWith(LogisticaId logisticaId) {
        LoteId loteId = LoteId.of("2020");
        BarrilId barrilId= BarrilId.of("4");
        var event = new BarrilEnvasado(loteId, barrilId);
        event.setAggregateRootId(logisticaId.value());
        return event;
    }



    private List<DomainEvent> history() {
        LoteId loteId = LoteId.of("2020");
        BarrilId barrilId= BarrilId.of("4");
        Capacidad capacidad= new Capacidad(30);
        TipoBarril tipoBarril= new TipoBarril("EuroG");
        Estado estado = new Estado("VACIO");
        return List.of(
                new LogisticaCreada(loteId),
                new BarrilAgregado(barrilId,capacidad,tipoBarril,estado),
                new BarrilEnvasado(loteId, barrilId)
        );
    }
}
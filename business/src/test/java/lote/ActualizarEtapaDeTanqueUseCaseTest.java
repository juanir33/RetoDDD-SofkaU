package lote;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.Tanque;
import com.robin.lote.command.ActualizarDescripcionDeTareaCommand;
import com.robin.lote.command.ActualizarEtapaDeTanqueCommand;
import com.robin.lote.events.*;
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
class ActualizarEtapaDeTanqueUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarEtapaDeTanqueUseCase useCase;

    @Test
    public void actualizarEtapaTest(){

        //arrange
        LoteId loteId = LoteId.of("21202");
        TanqueId tanqueId= TanqueId.of("4");
        Etapa etapa= new Etapa("Fermentacion");
        var commamd = new ActualizarEtapaDeTanqueCommand(loteId, tanqueId, etapa);
        when(repository.getEventsBy(commamd.getLoteId().value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(commamd))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event= (EtapaTanqueActualizada)events.get(0);
        Assertions.assertEquals("Fermentacion",etapa.value());
    }
    private List<DomainEvent> history() {

        BrewmasterId brewmasterId= BrewmasterId.of("32");
        TanqueId tanqueId = TanqueId.of("4");
        Etapa etapa= new Etapa("Maduracion");
        Capacidad capacidad = new Capacidad(1000);
        TipoTanque tipoTanque= new TipoTanque("Unitank");
        return List.of(
                new LoteCreado(brewmasterId),
                new TanqueAgregado(tanqueId,tipoTanque,capacidad,etapa)

        );
    }
    }


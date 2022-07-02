package lote;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.Brewmaster;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.LoteEventChange;
import com.robin.lote.Tarea;
import com.robin.lote.command.ActualizarTiempoTareaCommand;
import com.robin.lote.events.LoteCreado;
import com.robin.lote.events.TareaAgregada;
import com.robin.lote.events.TiempoDeTareaActualizado;
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
class ActualizarTiempoTareaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarTiempoTareaUseCase useCase;

    @Test
    public void actualizarTiempoTareaTest(){
        //arrange
        LoteId loteId= LoteId.of("2333");
        TareaId tareaId = TareaId.of("11");
        Tiempo tiempo= new Tiempo(2);
        var command= new ActualizarTiempoTareaCommand(loteId,tareaId,tiempo);
        when(repository.getEventsBy(command.getLoteId().value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TiempoDeTareaActualizado)events.get(0);
        Assertions.assertEquals(2, tiempo.value());


    }
    private List<DomainEvent> history() {
        LoteId loteId= LoteId.of("2333");
        BrewmasterId brewmasterId= BrewmasterId.of("32");
        Descripcion descripcion = new Descripcion("ES UNA TAREA DE LIMPIEZA");
        TipoTarea tipoTarea= new TipoTarea("Limpieza Acida");
        TareaId tareaId = TareaId.of("11");
        Tiempo tiempo= new Tiempo(24);
        return List.of(
                new LoteCreado(brewmasterId),
                new TareaAgregada(tareaId,tipoTarea,descripcion,tiempo)

        );
    }




}
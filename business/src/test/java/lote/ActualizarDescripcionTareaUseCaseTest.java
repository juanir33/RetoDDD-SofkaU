package lote;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.Lote;
import com.robin.lote.command.ActualizarDescripcionDeTareaCommand;
import com.robin.lote.events.DescripcionDeTareaActualizado;
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
class ActualizarDescripcionTareaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    ActualizarDescripcionTareaUseCase useCase;

    @Test
    public void actualizarDescripcionTareaTest(){
        //arrange
        LoteId loteId = LoteId.of("21");
        TareaId tareaId = TareaId.of("3");
        Descripcion descripcion= new Descripcion("Cipear madurador 1 con peracetico");
        var commamd = new ActualizarDescripcionDeTareaCommand(loteId,tareaId,descripcion);
        when(repository.getEventsBy(commamd.getLoteId().value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(commamd))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event= (DescripcionDeTareaActualizado)events.get(0);
        Assertions.assertEquals("Cipear madurador 1 con peracetico",descripcion.value());
    }
    private List<DomainEvent> history() {

        BrewmasterId brewmasterId= BrewmasterId.of("32");
        Descripcion descripcion = new Descripcion("ES UNA TAREA DE LIMPIEZA");
        TipoTarea tipoTarea= new TipoTarea("Limpieza Acida");
        TareaId tareaId = TareaId.of("3");
        Tiempo tiempo= new Tiempo(24);
        return List.of(
                new LoteCreado(brewmasterId),
                new TareaAgregada(tareaId,tipoTarea,descripcion,tiempo)

        );
    }


}
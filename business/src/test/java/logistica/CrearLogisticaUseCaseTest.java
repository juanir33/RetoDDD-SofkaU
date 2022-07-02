package logistica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.robin.logistica.commands.CrearLogisticaCommand;
import com.robin.logistica.events.LogisticaCreada;
import com.robin.logistica.values.LogisticaId;
import com.robin.lote.Lote;
import com.robin.lote.values.LoteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CrearLogisticaUseCaseTest {

    @InjectMocks
    CrearLogisticaUseCase useCase;

    @Test
    public void crearLogisticaTest(){
        //arrange
        LogisticaId logisticaId= LogisticaId.of("logi2");
        LoteId  loteId= LoteId.of("2020-1");
        var command= new CrearLogisticaCommand(logisticaId,loteId);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event= (LogisticaCreada)events.get(0);
        Assertions.assertEquals("logi2", logisticaId.value());
    }

}
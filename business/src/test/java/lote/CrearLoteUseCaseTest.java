package lote;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.command.CrearLoteComman;
import com.robin.lote.events.LoteCreado;
import com.robin.lote.values.LoteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class CrearLoteUseCaseTest {

    @InjectMocks
    CrearLoteUseCase useCase;

    @Test
    public  void crearLoteTest(){
        //arrange
        LoteId loteId = LoteId.of("2022-23rr");
        BrewmasterId brewmasterId = BrewmasterId.of("JUAN-22");
        var command = new CrearLoteComman(loteId, brewmasterId);

        //act
        var events= UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assertions
        var event = (LoteCreado)events.get(0);
        Assertions.assertEquals("2022-23rr", loteId.value());
        Assertions.assertEquals("JUAN-22", brewmasterId.value());

    }


}
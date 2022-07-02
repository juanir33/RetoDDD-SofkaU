package brewmaster;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.robin.brewmaster.commands.CrearBrewmasterCommand;
import com.robin.brewmaster.events.BrewmasterCreado;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class CrearBrewmasterUseCaseTest {

    @InjectMocks
    CrearBrewmasterUseCase useCase;

    @Test
    public void nuevoBrewmasterTest(){
        //arrange
        BrewmasterId brewmasterId= BrewmasterId.of("brew1");
        Nombre nombre = new Nombre("Ignacio");
        var command= new CrearBrewmasterCommand(brewmasterId,nombre);

        //act
        var events= UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().getDomainEvents();

        //assertions
        var event = (BrewmasterCreado)events.get(0);
        Assertions.assertEquals("brew1", brewmasterId.value());
        Assertions.assertEquals("Ignacio", nombre.value());
    }

}
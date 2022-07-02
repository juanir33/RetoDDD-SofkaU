package brewmaster;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.Cuenta;
import com.robin.brewmaster.commands.CambiarPasswordEnCuentaCommand;
import com.robin.brewmaster.events.BrewmasterCreado;
import com.robin.brewmaster.events.CuentaAsociada;
import com.robin.brewmaster.events.PasswordEnCuentaCambiada;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.brewmaster.values.CuentaId;
import com.robin.brewmaster.values.Password;
import com.robin.brewmaster.values.Usuario;
import com.robin.lote.values.Nombre;
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
class CambiarPasswordCuentaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarPasswordCuentaUseCase useCase;

    @Test
    public void cambiarPasswordTest(){
        //arrange
        BrewmasterId brewmasterId= BrewmasterId.of("brew1");
        Nombre nombre = new Nombre("Ignacio");
        CuentaId cuentaId= CuentaId.of("3432");
        Password password= new Password("abc1234");
        var command= new CambiarPasswordEnCuentaCommand(brewmasterId,cuentaId,password);
        when(repository.getEventsBy(command.getBrewmasterId().value())).thenReturn(history());

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event= (PasswordEnCuentaCambiada)events.get(0);
        Assertions.assertEquals("abc1234", password.value());

    }
    private List<DomainEvent> history(){
        BrewmasterId brewmasterId= BrewmasterId.of("brew1");
        Nombre nombre = new Nombre("Ignacio");
        CuentaId cuentaId= CuentaId.of("3432");
        Password password= new Password("abc22234");
        Usuario usuario= new Usuario("brewtreinta");
        Cuenta cuenta= new Cuenta(cuentaId,usuario,password);
        return List.of(
                new BrewmasterCreado(nombre),
                new CuentaAsociada(cuenta)
        );

    }

}
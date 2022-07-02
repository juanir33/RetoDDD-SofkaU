package brewmaster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.brewmaster.Brewmaster;
import com.robin.brewmaster.commands.CambiarPasswordEnCuentaCommand;

public class CambiarPasswordCuentaUseCase extends UseCase<RequestCommand<CambiarPasswordEnCuentaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarPasswordEnCuentaCommand> cambiarPasswordEnCuentaCommandRequestCommand) {
      var command= cambiarPasswordEnCuentaCommandRequestCommand.getCommand();
      var brew= Brewmaster.from(command.getBrewmasterId(),
              repository().getEventsBy(command.getBrewmasterId().value()));
      brew.cambiarPasswordEnCuenta(command.getCuentaId(),command.getPassword());
      emit().onResponse(new ResponseEvents(brew.getUncommittedChanges()));
    }
}

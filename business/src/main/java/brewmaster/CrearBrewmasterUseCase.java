package brewmaster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.brewmaster.Brewmaster;
import com.robin.brewmaster.commands.CrearBrewmasterCommand;

public class CrearBrewmasterUseCase extends UseCase<RequestCommand<CrearBrewmasterCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearBrewmasterCommand> crearBrewmasterCommandRequestCommand) {
       var command= crearBrewmasterCommandRequestCommand.getCommand();
       var brew= new Brewmaster(command.getEntityId(),command.getNombre());
       emit().onResponse(new ResponseEvents(brew.getUncommittedChanges()));

    }
}

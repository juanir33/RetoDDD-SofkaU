package lote;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.lote.Lote;
import com.robin.lote.command.CrearLoteComman;

public class CrearLoteUseCase extends UseCase<RequestCommand<CrearLoteComman>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearLoteComman> crearLoteCommanRequestCommand) {
        var command = crearLoteCommanRequestCommand.getCommand();
        var lote = new Lote(command.getLoteId(),command.getBrewmasterId());
        emit().onResponse(new ResponseEvents(lote.getUncommittedChanges()));
    }
}

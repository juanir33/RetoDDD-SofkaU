package logistica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.logistica.Logistica;
import com.robin.logistica.commands.CrearLogisticaCommand;

public class CrearLogisticaUseCase extends UseCase<RequestCommand<CrearLogisticaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearLogisticaCommand> crearLogisticaCommandRequestCommand) {
        var command= crearLogisticaCommandRequestCommand.getCommand();
        var logi = new Logistica(command.getLogisticaId(),command.getLoteId());
        emit().onResponse(new ResponseEvents(logi.getUncommittedChanges()));
    }
}

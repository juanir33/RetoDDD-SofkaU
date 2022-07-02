package logistica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.logistica.Logistica;
import com.robin.logistica.commands.CambiarAreaDeEncargadoCommand;
import com.robin.logistica.values.LogisticaId;

public class CambiarAreaDeEncargadoUseCase extends UseCase<RequestCommand<CambiarAreaDeEncargadoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarAreaDeEncargadoCommand> cambiarAreaDeEncargadoCommandRequestCommand) {
       var command= cambiarAreaDeEncargadoCommandRequestCommand.getCommand();
       var logistica=  Logistica.from(command.getLogisticaId(), repository().getEventsBy(command.getLogisticaId().value()));
       logistica.cambiarDeAreaAencargado(command.getArea());
       emit().onResponse(new ResponseEvents(logistica.getUncommittedChanges()));

    }
}

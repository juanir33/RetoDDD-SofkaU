package logistica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.logistica.Logistica;
import com.robin.logistica.commands.AgregarBarrilCommand;

public class AgregarBarrilUseCase extends UseCase<RequestCommand<AgregarBarrilCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarBarrilCommand> agregarBarrilCommandRequestCommand) {
       var command= agregarBarrilCommandRequestCommand.getCommand();
       var logi = Logistica.from(command.getLogisticaId(),
               repository().getEventsBy(command.getLogisticaId().value()));
       logi.agregarBarril(command.getBarrilId(),
               command.getCapacidad(),
               command.getTipoBarril(),
               command.getEstado());
       emit().onResponse(new ResponseEvents(logi.getUncommittedChanges()));
    }
}

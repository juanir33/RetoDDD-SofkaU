package logistica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.logistica.Logistica;
import com.robin.logistica.commands.EnvasarBarrilCommand;

public class EnvasarBarrilUseCase extends UseCase<RequestCommand<EnvasarBarrilCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EnvasarBarrilCommand> envasarBarrilCommandRequestCommand) {
      var command= envasarBarrilCommandRequestCommand.getCommand();
      var logis = Logistica.from(command.getLogisticaId(),
              repository().getEventsBy(command.getLogisticaId().value()));
      logis.envasarLote(command.getLoteId(),command.getBarrilId());
      emit().onResponse(new ResponseEvents(logis.getUncommittedChanges()));
    }
}

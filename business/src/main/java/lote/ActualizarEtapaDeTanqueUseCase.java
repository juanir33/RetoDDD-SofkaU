package lote;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.lote.Lote;
import com.robin.lote.command.ActualizarEtapaDeTanqueCommand;

public class ActualizarEtapaDeTanqueUseCase extends UseCase<RequestCommand<ActualizarEtapaDeTanqueCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEtapaDeTanqueCommand> actualizarEtapaDeTanqueCommandRequestCommand) {
      var command= actualizarEtapaDeTanqueCommandRequestCommand.getCommand();
        var lote = Lote.from(command.getLoteId(), repository().getEventsBy(command.getLoteId().value()));
        lote.actualizarEtapaTanque(command.getEtapa());
        emit().onResponse(new ResponseEvents(lote.getUncommittedChanges()));
    }
}

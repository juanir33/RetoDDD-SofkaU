package lote;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.lote.Lote;
import com.robin.lote.command.ActualizarDescripcionDeTareaCommand;

import static org.mockito.Mockito.when;

public class ActualizarDescripcionTareaUseCase extends UseCase<RequestCommand<ActualizarDescripcionDeTareaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionDeTareaCommand> actualizarDescripcionDeTareaCommandRequestCommand) {
        var command= actualizarDescripcionDeTareaCommandRequestCommand.getCommand();
        var lote = Lote.from(command.getLoteId(), repository().getEventsBy(command.getLoteId().value()));
        lote.actualizarDescripcionTarea(command.getTareaId(),command.getDescripcion());
        emit().onResponse(new ResponseEvents(lote.getUncommittedChanges()));
    }
}

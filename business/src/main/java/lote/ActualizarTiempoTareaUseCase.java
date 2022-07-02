package lote;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.robin.lote.Lote;
import com.robin.lote.command.ActualizarTiempoTareaCommand;

public class ActualizarTiempoTareaUseCase extends UseCase<RequestCommand<ActualizarTiempoTareaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTiempoTareaCommand> actualizarTiempoTareaCommandRequestCommand) {
       var command= actualizarTiempoTareaCommandRequestCommand.getCommand();
       var lote = Lote.from(command.getLoteId(), repository().getEventsBy(command.getLoteId().value()));
       lote.actualizarTiempoTarea(command.getTareaId(),command.getTiempo());
       emit().onResponse(new ResponseEvents(lote.getUncommittedChanges()));
    }
}

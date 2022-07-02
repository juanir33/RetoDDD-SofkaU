package logistica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.robin.logistica.Logistica;
import com.robin.logistica.events.BarrilEnvasado;
import com.robin.logistica.values.Estado;
import com.robin.logistica.values.LogisticaId;

public class ActualizarEstadoBarrilUseCase extends UseCase<TriggeredEvent<BarrilEnvasado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<BarrilEnvasado> barrilEnvasadoTriggeredEvent) {
       var event = barrilEnvasadoTriggeredEvent.getDomainEvent();
       var logis= Logistica.from(LogisticaId.of(event.aggregateRootId()), retrieveEvents());
       var newEstado = new Estado("LLENO");
       logis.actualizarEstadoDeBarril(event.getBarrilId(),newEstado);
       emit().onResponse(new ResponseEvents(logis.getUncommittedChanges()));
    }
}

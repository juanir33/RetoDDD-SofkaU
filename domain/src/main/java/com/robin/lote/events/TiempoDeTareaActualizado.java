package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.TareaId;
import com.robin.lote.values.Tiempo;

public class TiempoDeTareaActualizado extends DomainEvent {
    public TiempoDeTareaActualizado(TareaId tareaId, Tiempo tiempo) {
        super();
    }
}

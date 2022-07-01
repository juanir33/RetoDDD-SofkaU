package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.TareaId;
import com.robin.lote.values.Tiempo;

public class TiempoDeTareaActualizado extends DomainEvent {
    private final TareaId tareaId;
    private final Tiempo tiempo;

    public TiempoDeTareaActualizado(TareaId tareaId, Tiempo tiempo) {

        super("robin.lote.TiempoDeTareaActualizado");
        this.tareaId = tareaId;
        this.tiempo = tiempo;
    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }
}

package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Descripcion;
import com.robin.lote.values.TareaId;

public class DescripcionDeTareaActualizado extends DomainEvent {
    private final TareaId tareaId;
    private final Descripcion descripcion;

    public DescripcionDeTareaActualizado(TareaId tareaId, Descripcion descripcion) {
        super("robin.lote.DescripcionDeTareaActualizado");

        this.tareaId = tareaId;
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public TareaId getTareaId() {
        return tareaId;
    }
}

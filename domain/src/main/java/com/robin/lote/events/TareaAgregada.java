package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.TareaId;
import com.robin.lote.values.TipoTarea;
import com.robin.lote.values.Descripcion;
import com.robin.lote.values.Tiempo;

public class TareaAgregada extends DomainEvent {
    private final TareaId tareaId;
    private final TipoTarea tipoTarea;
    private final Descripcion descripcion;
    private final Tiempo tiempo;

    public TareaAgregada(TareaId tareaId, TipoTarea tipoTarea, Descripcion descripcion, Tiempo tiempo) {

        super("robin.lote.TareaAgregada");
        this.tareaId = tareaId;
        this.tipoTarea = tipoTarea;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public TipoTarea getTipoTarea() {
        return tipoTarea;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }
}


package com.robin.lote;

import co.com.sofka.domain.generic.Entity;
import com.robin.lote.values.Descripcion;
import com.robin.lote.values.TareaId;
import com.robin.lote.values.Tiempo;
import com.robin.lote.values.TipoTarea;

import java.util.Objects;

public class Tarea extends Entity<TareaId> {
    private TipoTarea tipoTarea;
    private Tiempo tiempo;
    private Descripcion descripcion;

    public Tarea(TareaId entityId, TipoTarea tipoTarea, Tiempo tiempo, Descripcion descripcion) {
        super(entityId);
        this.tipoTarea = tipoTarea;
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion= Objects.requireNonNull(descripcion);

    }

    public void actualizarTiempo(Tiempo tiempo){
        this.tiempo= Objects.requireNonNull(tiempo);

    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public TipoTarea tipoTarea() {
        return tipoTarea;
    }

    public Tiempo tiempo() {
        return tiempo;
    }
}

package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.values.Area;
import com.robin.logistica.values.EncargadoId;
import com.robin.lote.values.Nombre;

public class EncargadoAsignado extends DomainEvent {
    private final EncargadoId encargadoId;
    private final Nombre nombre;
    private final Area area;

    public EncargadoAsignado(EncargadoId encargadoId, Nombre nombre, Area area) {
        super("robin.logistica.EncargadoAsignado");
        this.encargadoId = encargadoId;
        this.nombre = nombre;
        this.area = area;
    }

    public EncargadoId getEncargadoId() {
        return encargadoId;
    }

    public Area getArea() {
        return area;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

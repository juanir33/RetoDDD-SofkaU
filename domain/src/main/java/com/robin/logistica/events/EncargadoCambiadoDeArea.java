package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.values.Area;

public class EncargadoCambiadoDeArea extends DomainEvent {
    private final Area area;

    public EncargadoCambiadoDeArea(Area area) {
        super("robin.logistica.EncargadoCambiadoDeArea");
        this.area = area;
    }

    public Area getArea() {
        return area;
    }
}

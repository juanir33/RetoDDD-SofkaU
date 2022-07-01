package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Descripcion;

public class DescripcionProtocoloActualizada extends DomainEvent {
    private final Descripcion descripcion;

    public DescripcionProtocoloActualizada(Descripcion descripcion) {
        super("robin.logistica.DescripcionProtocoloActualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}

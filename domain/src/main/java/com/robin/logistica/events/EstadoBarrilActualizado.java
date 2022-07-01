package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.values.BarrilId;
import com.robin.logistica.values.Estado;

public class EstadoBarrilActualizado extends DomainEvent {
    private final BarrilId barrilId;
    private final Estado estado;

    public EstadoBarrilActualizado(BarrilId barrilId, Estado estado) {
        super("robin.logistica.EstadoBarrilActualizado");
        this.barrilId = barrilId;
        this.estado = estado;

    }

    public BarrilId getBarrilId() {
        return barrilId;
    }

    public Estado getEstado() {
        return estado;
    }
}

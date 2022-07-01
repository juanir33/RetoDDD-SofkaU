package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.values.BarrilId;
import com.robin.logistica.values.Capacidad;
import com.robin.logistica.values.Estado;
import com.robin.logistica.values.TipoBarril;

public class BarrilAgregado extends DomainEvent {
    private final BarrilId barrilId;
    private final Capacidad capacidad;
    private final TipoBarril tipoBarril;
    private final Estado estado;

    public BarrilAgregado(BarrilId barrilId, Capacidad capacidad, TipoBarril tipoBarril, Estado estado) {
        super("robin.logistica.BarrilAgregado");
        this.barrilId = barrilId;
        this.capacidad = capacidad;
        this.tipoBarril = tipoBarril;
        this.estado = estado;
    }

    public BarrilId getBarrilId() {
        return barrilId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public TipoBarril getTipoBarril() {
        return tipoBarril;
    }

    public Estado getEstado() {
        return estado;
    }
}

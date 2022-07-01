package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Capacidad;
import com.robin.lote.values.TanqueId;
import com.robin.lote.values.TipoTanque;

public class TanqueAgregado extends DomainEvent {
    private final TanqueId tanqueId;
    private final TipoTanque tipoTanque;
    private final Capacidad capacidad;

    public TanqueAgregado(TanqueId tanqueId, TipoTanque tipoTanque, Capacidad capacidad) {

        super("robin.lote.TanqueAgregado");
        this.tanqueId = tanqueId;
        this.tipoTanque = tipoTanque;
        this.capacidad = capacidad;
    }

    public TanqueId getTanqueId() {
        return tanqueId;
    }

    public TipoTanque getTipoTanque() {
        return tipoTanque;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}

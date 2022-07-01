package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Capacidad;
import com.robin.lote.values.Etapa;
import com.robin.lote.values.TanqueId;
import com.robin.lote.values.TipoTanque;

public class TanqueAgregado extends DomainEvent {
    private final TanqueId tanqueId;
    private final TipoTanque tipoTanque;
    private final Capacidad capacidad;
    private final Etapa etapa;

    public TanqueAgregado(TanqueId tanqueId, TipoTanque tipoTanque, Capacidad capacidad, Etapa etapa) {

        super("robin.lote.TanqueAgregado");
        this.tanqueId = tanqueId;
        this.tipoTanque = tipoTanque;
        this.capacidad = capacidad;
        this.etapa = etapa;
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

    public Etapa getEtapa() {
        return etapa;
    }
}

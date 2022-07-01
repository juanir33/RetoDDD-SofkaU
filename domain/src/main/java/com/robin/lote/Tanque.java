package com.robin.lote;

import co.com.sofka.domain.generic.Entity;
import com.robin.lote.values.Capacidad;
import com.robin.lote.values.Etapa;
import com.robin.lote.values.TanqueId;
import com.robin.lote.values.TipoTanque;

import java.util.Objects;

public class Tanque extends Entity<TanqueId> {
    private Capacidad capacidad;
    private TipoTanque tipoTanque;
    private Etapa etapa;

    public Tanque(TanqueId entityId, Capacidad capacidad, TipoTanque tipoTanque, Etapa etapa) {
        super(entityId);
        this.capacidad = capacidad;
        this.tipoTanque = tipoTanque;
        this.etapa = etapa;
    }

    public void actualizarEtapa(Etapa etapa){
        this.etapa= Objects.requireNonNull(etapa);

    }

    public Capacidad capacidad() {
        return capacidad;
    }

    public Etapa etapatapa() {
        return etapa;
    }

    public TipoTanque tipoTanque() {
        return tipoTanque;
    }
}
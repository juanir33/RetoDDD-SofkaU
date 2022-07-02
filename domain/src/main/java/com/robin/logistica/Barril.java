package com.robin.logistica;

import co.com.sofka.domain.generic.Entity;
import com.robin.logistica.values.BarrilId;
import com.robin.logistica.values.Estado;
import com.robin.logistica.values.TipoBarril;
import com.robin.logistica.values.Capacidad;
import com.robin.lote.Lote;
import com.robin.lote.values.LoteId;

public class Barril extends Entity<BarrilId> {
    private Capacidad capacidad;
    private TipoBarril tipoBarril;

    private Estado estado;
    private LoteId loteId;

    public Barril(BarrilId entityId, Capacidad capacidad, TipoBarril tipoBarril, Estado estado) {
        super(entityId);
        this.capacidad = capacidad;
        this.tipoBarril = tipoBarril;
        this.estado= estado;
    }
    public void actualizarEstado(Estado estado){
        this.estado= estado;
    }
    public void llenarBarril(LoteId loteId){
        this.loteId= loteId;

    }

    public Capacidad capacidad() {
        return capacidad;
    }

    public TipoBarril tipoBarril() {
        return tipoBarril;
    }

    public Estado estado() {
        return estado;
    }

}

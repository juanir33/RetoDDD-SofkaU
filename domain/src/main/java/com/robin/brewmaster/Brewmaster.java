package com.robin.brewmaster;

import co.com.sofka.domain.generic.AggregateEvent;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.values.Nombre;

public class Brewmaster extends AggregateEvent<BrewmasterId> {
    protected Nombre nombre;
    protected LibretaSanitaria libretaSanitaria;
    protected Laboratorio laboratorio;
    protected Cuenta cuenta;

    public Brewmaster(BrewmasterId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
        appendChange(new BrewmasterCreado(nombre)).apply();
    }
}

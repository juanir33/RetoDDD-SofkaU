package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.Brewmaster;
import com.robin.lote.Receta;
import com.robin.lote.values.BrewmasterId;

public class LoteCreado extends DomainEvent {
    private final Receta receta;
    private final BrewmasterId brewmasterId;
    public LoteCreado(Receta receta, BrewmasterId brewmasterId) {
        super("com.robin.LoteCreado");
        this.receta= receta;
        this.brewmasterId= brewmasterId;


    }

    public BrewmasterId getBrewmasterId() {
        return brewmasterId;
    }

    public Receta getReceta() {
        return receta;
    }
}

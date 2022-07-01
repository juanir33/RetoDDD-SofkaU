package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.Receta;
import com.robin.lote.values.BrewmasterId;

public class LoteCreado extends DomainEvent {

    private final BrewmasterId brewmasterId;
    public LoteCreado(BrewmasterId brewmasterId) {
        super("com.robin.LoteCreado");

        this.brewmasterId= brewmasterId;


    }

    public BrewmasterId getBrewmasterId() {
        return brewmasterId;
    }


}

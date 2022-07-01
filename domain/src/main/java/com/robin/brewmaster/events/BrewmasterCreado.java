package com.robin.brewmaster.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Nombre;

public class BrewmasterCreado extends DomainEvent {
    private final Nombre nombre;

    public BrewmasterCreado(Nombre nombre) {
        super("robin.brewmaster.BrewmasterCreado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

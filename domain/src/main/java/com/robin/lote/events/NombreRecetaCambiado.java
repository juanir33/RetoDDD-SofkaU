package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Nombre;

public class NombreRecetaCambiado extends DomainEvent {
    private final Nombre nombre;

    public NombreRecetaCambiado(Nombre nombre) {
        super("robin.lote.NombreRecetaCambiado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

package com.robin.brewmaster.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.values.Nombre;

public class CrearBrewmasterCommand extends Command {
    private final BrewmasterId entityId;
    private final Nombre nombre;

    public CrearBrewmasterCommand(BrewmasterId entityId, Nombre nombre) {
        this.entityId = entityId;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public BrewmasterId getEntityId() {
        return entityId;
    }
}

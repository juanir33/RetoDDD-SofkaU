package com.robin.logistica.values;

import co.com.sofka.domain.generic.Identity;
import com.robin.brewmaster.values.BrewmasterId;

public class EncargadoId extends Identity {
    public EncargadoId(String uuid) {
        super(uuid);
    }

    public EncargadoId() {
    }

    public static EncargadoId of(String uuid){
        return  new EncargadoId(uuid);
    }
}

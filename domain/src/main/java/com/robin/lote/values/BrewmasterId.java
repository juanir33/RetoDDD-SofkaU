package com.robin.lote.values;

import co.com.sofka.domain.generic.Identity;

public class BrewmasterId extends Identity {

    public BrewmasterId(String uuid) {
        super(uuid);
    }

    public BrewmasterId() {
    }

    public static BrewmasterId of(String uuid){
        return  new BrewmasterId(uuid);
    }
}

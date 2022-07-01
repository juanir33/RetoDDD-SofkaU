package com.robin.logistica.values;

import co.com.sofka.domain.generic.Identity;
import com.robin.brewmaster.values.BrewmasterId;

public class BarrilId extends Identity {
    public BarrilId(String uuid) {
        super(uuid);
    }

    public BarrilId() {
    }

    public static BarrilId of(String uuid){
        return  new BarrilId(uuid);
    }
}

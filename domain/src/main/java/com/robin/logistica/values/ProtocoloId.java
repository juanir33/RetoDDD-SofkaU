package com.robin.logistica.values;

import co.com.sofka.domain.generic.Identity;
import com.robin.brewmaster.values.BrewmasterId;

public class ProtocoloId extends Identity {
    public ProtocoloId(String uuid) {
        super(uuid);
    }

    public ProtocoloId() {
    }

    public static ProtocoloId of(String uuid){
        return  new ProtocoloId(uuid);
    }
}

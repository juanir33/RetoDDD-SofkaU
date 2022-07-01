package com.robin.lote.values;

import co.com.sofka.domain.generic.Identity;

public class TanqueId extends Identity {

    public TanqueId() {
    }

    public TanqueId(String uuid) {
        super(uuid);
    }

    public static TanqueId of(String uuid){
        return new TanqueId(uuid);
    }
}

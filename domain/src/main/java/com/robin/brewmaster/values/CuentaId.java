package com.robin.brewmaster.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity {
    public CuentaId(String uuid) {
        super(uuid);
    }

    public CuentaId() {
    }
    public static CuentaId of(String uuid){
        return new CuentaId(uuid);
    }
}

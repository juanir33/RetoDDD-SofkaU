package com.robin.lote.values;

import co.com.sofka.domain.generic.Identity;

public class LoteId extends Identity {
    public LoteId(String uuid) {
        super(uuid);
    }

    public LoteId() {
    }

    public static LoteId of(String uuid){
        return  new LoteId(uuid);
    }
}

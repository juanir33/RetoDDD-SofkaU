package com.robin.lote.values;

import co.com.sofka.domain.generic.Identity;

public class TareaId extends Identity {

    public TareaId(String uuid) {
        super(uuid);
    }

    public TareaId() {
    }
    public static TareaId of(String uuid){
        return new TareaId(uuid);
    }
}

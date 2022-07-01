package com.robin.lote.values;

import co.com.sofka.domain.generic.Identity;
import com.robin.lote.Receta;

public class RecetaId extends Identity {
    public RecetaId(String uuid) {
        super(uuid);
    }

    public RecetaId() {
    }

    public static RecetaId of(String uuid){
        return  new RecetaId(uuid);
    }
}

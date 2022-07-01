package com.robin.brewmaster.values;

import co.com.sofka.domain.generic.Identity;
import com.robin.brewmaster.LibretaSanitaria;
import com.robin.lote.values.TareaId;

public class LibretaSanitariaId extends Identity {
    public LibretaSanitariaId(String uuid) {
        super(uuid);
    }

    public LibretaSanitariaId() {
    }
    public static LibretaSanitariaId of(String uuid){
        return new LibretaSanitariaId(uuid);
    }
}

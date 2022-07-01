package com.robin.brewmaster.values;

import co.com.sofka.domain.generic.Identity;
import com.robin.lote.values.TareaId;

public class LaboratorioId extends Identity {
    public LaboratorioId(String uuid) {
        super(uuid);
    }

    public LaboratorioId() {
    }
    public static LaboratorioId of(String uuid){
        return new LaboratorioId(uuid);
    }
}

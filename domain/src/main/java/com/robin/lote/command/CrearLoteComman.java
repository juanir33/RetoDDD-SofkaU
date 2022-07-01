package com.robin.lote.command;

import co.com.sofka.domain.generic.Command;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.lote.values.LoteId;

public class CrearLoteComman extends Command {
    private final LoteId loteId;
    private final BrewmasterId brewmasterId;

    public CrearLoteComman(LoteId loteId, BrewmasterId brewmasterId) {
        this.loteId = loteId;
        this.brewmasterId = brewmasterId;
    }

    public LoteId getLoteId() {
        return loteId;
    }

    public BrewmasterId getBrewmasterId() {
        return brewmasterId;
    }
}

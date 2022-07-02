package com.robin.logistica.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.logistica.values.LogisticaId;
import com.robin.lote.values.LoteId;

public class CrearLogisticaCommand extends Command {
    private final LogisticaId logisticaId;
    private final LoteId loteId;

    public CrearLogisticaCommand(LogisticaId logisticaId, LoteId loteId) {
        this.logisticaId = logisticaId;
        this.loteId = loteId;
    }

    public LogisticaId getLogisticaId() {
        return logisticaId;
    }

    public LoteId getLoteId() {
        return loteId;
    }
}

package com.robin.logistica.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.logistica.values.BarrilId;
import com.robin.logistica.values.LogisticaId;
import com.robin.lote.values.LoteId;

public class EnvasarBarrilCommand extends Command {
    private final LogisticaId logisticaId;
    private final BarrilId barrilId;
    private final LoteId loteId;

    public EnvasarBarrilCommand(LogisticaId logisticaId, BarrilId barrilId, LoteId loteId) {
        this.logisticaId = logisticaId;
        this.barrilId = barrilId;
        this.loteId = loteId;
    }

    public LogisticaId getLogisticaId() {
        return logisticaId;
    }

    public BarrilId getBarrilId() {
        return barrilId;
    }

    public LoteId getLoteId() {
        return loteId;
    }
}

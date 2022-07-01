package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.values.BarrilId;
import com.robin.lote.values.LoteId;

public class BarrilEnvasado extends DomainEvent {
    private final LoteId loteId;
    private final BarrilId barrilId;

    public BarrilEnvasado(LoteId loteId, BarrilId barrilId) {
        super("robin.logistica.BarrilEnvasado");
        this.loteId = loteId;
        this.barrilId = barrilId;
    }

    public BarrilId getBarrilId() {
        return barrilId;
    }

    public LoteId getLoteId() {
        return loteId;
    }
}

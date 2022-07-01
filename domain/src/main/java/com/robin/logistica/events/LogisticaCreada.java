package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.LoteId;

public class LogisticaCreada extends DomainEvent {

    private final LoteId loteId;

    public LogisticaCreada(LoteId loteId) {
        super("robin.logistica.LogisticaCreada");
        this.loteId = loteId;
    }

    public LoteId getLoteId() {
        return loteId;
    }
}

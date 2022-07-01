package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Etapa;

public class EtapaTanqueActualizada extends DomainEvent {
    private final Etapa etapa;

    public EtapaTanqueActualizada(Etapa etapa) {

        super("robin.lote.EtapaTanqueActualizada");

        this.etapa = etapa;
    }

    public Etapa getEtapa() {
        return etapa;
    }
}

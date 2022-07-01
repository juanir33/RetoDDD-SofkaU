package com.robin.brewmaster.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.LaboratorioId;

public class LaboratorioAgregado extends DomainEvent {
    private final LaboratorioId laboratorioId;

    public LaboratorioAgregado(LaboratorioId laboratorioId) {
        super("robin.brewmaster.LaboratorioAgregado");
        this.laboratorioId = laboratorioId;
    }

    public LaboratorioId getLaboratorioId() {
        return laboratorioId;
    }
}

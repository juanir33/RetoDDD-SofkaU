package com.robin.brewmaster.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.Ensayo;

public class EnsayoEnLabroatorioAgregado extends DomainEvent {
    private final Ensayo ensayo;

    public EnsayoEnLabroatorioAgregado(Ensayo ensayo) {
        super("robin.brewmaster.EnsayoEnLabroatorioAgregado");
        this.ensayo = ensayo;
    }

    public Ensayo getEnsayo() {
        return ensayo;
    }
}

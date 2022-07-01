package com.robin.brewmaster.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.Estudio;

public class EstudioEnLibretaAgregado extends DomainEvent {
    private final Estudio estudio;

    public EstudioEnLibretaAgregado(Estudio estudio) {
        super("robin.brewmaster.EstudioEnLibretaAgregado");
        this.estudio = estudio;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}

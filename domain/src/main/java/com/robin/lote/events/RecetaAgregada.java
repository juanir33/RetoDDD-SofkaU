package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Batch;
import com.robin.lote.values.Nombre;
import com.robin.lote.values.RecetaId;
import com.robin.lote.values.TipoCerveza;

public class RecetaAgregada extends DomainEvent {
    private final RecetaId entityId;
    private final TipoCerveza tipoCerveza;
    private final Nombre nombre;
    private final Batch batch;

    public RecetaAgregada(RecetaId entityId, TipoCerveza tipoCerveza, Nombre nombre, Batch batch) {
        super("robin.lote.RecetaAgregada");
        this.entityId = entityId;
        this.tipoCerveza = tipoCerveza;
        this.nombre = nombre;
        this.batch = batch;
    }

    public RecetaId getEntityId() {
        return entityId;
    }

    public TipoCerveza getTipoCerveza() {
        return tipoCerveza;
    }

    public Batch getBatch() {
        return batch;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

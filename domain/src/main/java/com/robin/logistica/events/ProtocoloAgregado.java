package com.robin.logistica.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.values.ProtocoloId;
import com.robin.logistica.values.TipoProtocolo;
import com.robin.lote.values.Descripcion;

public class ProtocoloAgregado extends DomainEvent {
    private final ProtocoloId protocoloId;
    private final TipoProtocolo tipoProtocolo;
    private final Descripcion descripcion;

    public ProtocoloAgregado(ProtocoloId protocoloId, TipoProtocolo tipoProtocolo, Descripcion descripcion) {
        super("robin.logistica.ProtocoloAgregado");
        this.protocoloId = protocoloId;
        this.tipoProtocolo = tipoProtocolo;
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public ProtocoloId getProtocoloId() {
        return protocoloId;
    }

    public TipoProtocolo getTipoProtocolo() {
        return tipoProtocolo;
    }
}

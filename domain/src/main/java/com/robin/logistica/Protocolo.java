package com.robin.logistica;

import co.com.sofka.domain.generic.Entity;
import com.robin.logistica.values.ProtocoloId;
import com.robin.logistica.values.TipoProtocolo;
import com.robin.lote.values.Descripcion;

public class Protocolo extends Entity<ProtocoloId> {


    private TipoProtocolo tipoProtocolo;
    private Descripcion descripcion;

    public Protocolo(ProtocoloId entityId, TipoProtocolo tipoProtocolo, Descripcion descripcion) {
        super(entityId);
        this.tipoProtocolo = tipoProtocolo;
        this.descripcion = descripcion;
    }

    public void actualizarDescripcionProtocolo(Descripcion descripcion){
        this.descripcion= descripcion;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public TipoProtocolo tipoProtocolo() {
        return tipoProtocolo;
    }
}

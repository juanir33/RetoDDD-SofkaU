package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.Capacidad;
import com.robin.lote.values.TanqueId;
import com.robin.lote.values.TipoTanque;

public class TanqueAsignado extends DomainEvent {
    public TanqueAsignado(TanqueId tanqueId, TipoTanque tipoTanque, Capacidad capacidad) {
        super();
    }
}

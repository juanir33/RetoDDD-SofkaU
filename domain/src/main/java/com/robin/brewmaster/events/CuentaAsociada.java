package com.robin.brewmaster.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.Cuenta;

public class CuentaAsociada extends DomainEvent {
    private final Cuenta cuenta;

    public CuentaAsociada(Cuenta cuenta) {
        super("robin.brewmaster.CuentaAsociada");
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}

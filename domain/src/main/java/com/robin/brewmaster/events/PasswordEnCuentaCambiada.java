package com.robin.brewmaster.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.CuentaId;
import com.robin.brewmaster.values.Password;

public class PasswordEnCuentaCambiada extends DomainEvent {
    private final CuentaId cuentaId;
    private final Password password;

    public PasswordEnCuentaCambiada(CuentaId cuentaId, Password password) {
        super("robin.brewmaster.PasswordEnCuentaCambiada");
        this.cuentaId = cuentaId;
        this.password = password;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Password getPassword() {
        return password;
    }
}

package com.robin.brewmaster.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.brewmaster.values.CuentaId;
import com.robin.brewmaster.values.Password;

public class CambiarPasswordEnCuentaCommand extends Command {

    private final BrewmasterId brewmasterId;
    private final CuentaId cuentaId;
    private final Password password;

    public CambiarPasswordEnCuentaCommand(BrewmasterId brewmasterId,CuentaId cuentaId, Password password) {
        this.brewmasterId = brewmasterId;
        this.cuentaId = cuentaId;
        this.password = password;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Password getPassword() {
        return password;
    }

    public BrewmasterId getBrewmasterId() {
        return brewmasterId;
    }
}

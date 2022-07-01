package com.robin.brewmaster;

import co.com.sofka.domain.generic.Entity;
import com.robin.brewmaster.values.CuentaId;
import com.robin.brewmaster.values.Password;
import com.robin.brewmaster.values.Usuario;

public class Cuenta  extends Entity<CuentaId> {


    private Usuario usuario;
    private Password password;

    public Cuenta(CuentaId entityId, Usuario usuario, Password password) {
        super(entityId);
        this.usuario = usuario;
        this.password = password;
    }
    public void cambiarPassword(Password password){
          this.password = password;

    }

    public Password password() {
        return password;
    }

    public Usuario usuario() {
        return usuario;
    }
}

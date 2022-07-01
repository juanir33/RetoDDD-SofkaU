package com.robin.brewmaster;

import co.com.sofka.domain.generic.EventChange;
import com.robin.brewmaster.events.*;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.brewmaster.values.LibretaSanitariaId;

import java.util.Objects;

public class BrewmasterEventChange extends EventChange {
    public BrewmasterEventChange(Brewmaster brewmaster) {
        apply((BrewmasterCreado event)->{
            brewmaster.nombre= event.getNombre();
        });
        apply((CuentaAsociada event)->{
            brewmaster.cuenta= event.getCuenta();
        });
        apply((LaboratorioAgregado event)->{
            brewmaster.laboratorio= new Laboratorio(event.getLaboratorioId());
        });
        apply((LibretaSanitariaAgregada event)->{
            brewmaster.libretaSanitaria= new LibretaSanitaria(event.getLibretaSanitariaId(), event.getVencimiento());
        });
        apply((EnsayoEnLabroatorioAgregado event)->{
            brewmaster.laboratorio.agregarEnsayo(event.getEnsayo());
        });
        apply((EstudioEnLibretaAgregado event)->{
            brewmaster.libretaSanitaria.agregarEstudio(event.getEstudio());
        });
        apply((PasswordEnCuentaCambiada event)->{
            if(!brewmaster.cuenta.identity().equals(event.getCuentaId())){
                throw new IllegalArgumentException("La cuenta que busca no existe");
            }
            brewmaster.cuenta.cambiarPassword(event.getPassword());
        });
    }
}

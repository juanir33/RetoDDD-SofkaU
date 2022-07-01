package com.robin.brewmaster;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.events.*;
import com.robin.brewmaster.values.*;
import com.robin.lote.Lote;
import com.robin.lote.values.LoteId;
import com.robin.lote.values.Nombre;

import java.util.List;

public class Brewmaster extends AggregateEvent<BrewmasterId> {
    protected Nombre nombre;
    protected LibretaSanitaria libretaSanitaria;
    protected Laboratorio laboratorio;
    protected Cuenta cuenta;

    public Brewmaster(BrewmasterId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
        appendChange(new BrewmasterCreado(nombre)).apply();
    }
    private Brewmaster(BrewmasterId brewmasterId){
        super(brewmasterId);
        subscribe(new BrewmasterEventChange(this));
    }
    public static Brewmaster from(BrewmasterId brewmasterId, List<DomainEvent> eventList){
        Brewmaster brewmaster = new Brewmaster(brewmasterId);
        eventList.forEach(brewmaster::applyEvent);
        return brewmaster;

    }
    public void asociarCuenta(Cuenta cuenta){
        appendChange(new CuentaAsociada(cuenta)).apply();
    }
    public void agregarLaboratorio(LaboratorioId laboratorioId){
        appendChange(new LaboratorioAgregado(laboratorioId)).apply();
    }
    public void agregarLibretaSanitaria(LibretaSanitariaId libretaSanitariaId, Vencimiento vencimiento){
        appendChange(new LibretaSanitariaAgregada(libretaSanitariaId,vencimiento)).apply();
    }
    public void agregarEstudioEnLibreta(Estudio estudio){
        appendChange(new EstudioEnLibretaAgregado(estudio)).apply();
    }
    public void agregarEnsayoEnLaboratorio(Ensayo ensayo){
        appendChange(new EnsayoEnLabroatorioAgregado(ensayo)).apply();
    }
    public void cambiarPasswordEnCuenta(CuentaId cuentaId, Password password){
        appendChange(new PasswordEnCuentaCambiada(cuentaId,password)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Cuenta cuenta() {
        return cuenta;
    }

    public Laboratorio laboratorio() {
        return laboratorio;
    }

    public LibretaSanitaria libretaSanitaria() {
        return libretaSanitaria;
    }


}

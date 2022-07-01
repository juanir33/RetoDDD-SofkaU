package com.robin.brewmaster;

import co.com.sofka.domain.generic.Entity;
import com.robin.brewmaster.values.LibretaSanitariaId;
import com.robin.brewmaster.values.Vencimiento;
import com.robin.brewmaster.values.Estudio;

import java.util.HashSet;
import java.util.Set;

public class LibretaSanitaria extends Entity<LibretaSanitariaId> {


    private Vencimiento vencimiento;
    private Set<Estudio> estudios;

    public LibretaSanitaria(LibretaSanitariaId entityId, Vencimiento vencimiento) {
        super(entityId);
        this.vencimiento = vencimiento;
        this.estudios = new HashSet<>();
    }
    public void agregarEstudio(Estudio estudio){
        this.estudios.add(estudio);

    }

    public Set<Estudio> estudios() {
        return estudios;
    }

    public Vencimiento vencimiento() {
        return vencimiento;
    }
}

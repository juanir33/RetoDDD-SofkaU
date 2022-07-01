package com.robin.brewmaster;

import co.com.sofka.domain.generic.Entity;
import com.robin.brewmaster.values.Ensayo;
import com.robin.brewmaster.values.Estudio;
import com.robin.brewmaster.values.LaboratorioId;

import java.util.HashSet;
import java.util.Set;

public class Laboratorio extends Entity<LaboratorioId> {
    private final Set<Ensayo> ensayos;

    public Laboratorio(LaboratorioId entityId) {
        super(entityId);
        this.ensayos= new HashSet<>();
    }
    public void agregarEnsayo(Ensayo ensayo){
        this.ensayos.add(ensayo);

    }

    public Set<Ensayo> ensayos() {
        return ensayos;
    }

}

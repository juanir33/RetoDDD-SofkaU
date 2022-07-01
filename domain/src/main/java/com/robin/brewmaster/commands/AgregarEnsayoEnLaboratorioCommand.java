package com.robin.brewmaster.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.brewmaster.values.*;

public class AgregarEnsayoEnLaboratorioCommand extends Command {
    private final BrewmasterId brewmasterId;
    private final LaboratorioId laboratorioId;
    private final Ensayo ensayo;

    public AgregarEnsayoEnLaboratorioCommand(BrewmasterId brewmasterId, LaboratorioId laboratorioId, Ensayo ensayo) {
        this.brewmasterId = brewmasterId;
        this.laboratorioId = laboratorioId;
        this.ensayo = ensayo;
    }

    public BrewmasterId getBrewmasterId() {
        return brewmasterId;
    }

    public LaboratorioId getLaboratorioId() {
        return laboratorioId;
    }

    public Ensayo getEnsayo() {
        return ensayo;
    }
}

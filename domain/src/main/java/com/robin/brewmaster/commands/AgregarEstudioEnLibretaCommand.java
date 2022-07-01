package com.robin.brewmaster.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.brewmaster.Brewmaster;
import com.robin.brewmaster.values.BrewmasterId;
import com.robin.brewmaster.values.Estudio;
import com.robin.brewmaster.values.LibretaSanitariaId;

public class AgregarEstudioEnLibretaCommand extends Command {

    private final BrewmasterId brewmasterId;
    private final LibretaSanitariaId libretaSanitariaId;
    private final Estudio estudio;

    public AgregarEstudioEnLibretaCommand(BrewmasterId brewmasterId, LibretaSanitariaId libretaSanitariaId, Estudio estudio) {
        this.brewmasterId = brewmasterId;
        this.libretaSanitariaId = libretaSanitariaId;
        this.estudio = estudio;
    }

    public BrewmasterId getBrewmasterId() {
        return brewmasterId;
    }

    public LibretaSanitariaId getLibretaSanitariaId() {
        return libretaSanitariaId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}

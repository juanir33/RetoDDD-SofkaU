package com.robin.logistica.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.logistica.values.Area;
import com.robin.logistica.values.EncargadoId;
import com.robin.logistica.values.LogisticaId;

public class CambiarAreaDeEncargadoCommand extends Command {
    private final LogisticaId logisticaId;
    private final EncargadoId encargadoId;
    private final Area area;

    public CambiarAreaDeEncargadoCommand(LogisticaId logisticaId, EncargadoId encargadoId, Area area) {
        this.logisticaId = logisticaId;
        this.encargadoId = encargadoId;
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public EncargadoId getEncargadoId() {
        return encargadoId;
    }

    public LogisticaId getLogisticaId() {
        return logisticaId;
    }
}

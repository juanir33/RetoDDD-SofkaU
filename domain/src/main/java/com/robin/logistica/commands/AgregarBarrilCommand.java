package com.robin.logistica.commands;

import co.com.sofka.domain.generic.Command;
import com.robin.logistica.values.*;

public class AgregarBarrilCommand extends Command {
    private final LogisticaId logisticaId;
    private final BarrilId barrilId;
    private final Capacidad capacidad;
    private final TipoBarril tipoBarril;
    private final Estado estado;

    public AgregarBarrilCommand(LogisticaId logisticaId,
                                BarrilId barrilId,
                                Capacidad capacidad,
                                TipoBarril tipoBarril,
                                Estado estado) {
        this.logisticaId = logisticaId;
        this.barrilId = barrilId;
        this.capacidad = capacidad;
        this.tipoBarril = tipoBarril;
        this.estado = estado;
    }

    public LogisticaId getLogisticaId() {
        return logisticaId;
    }

    public BarrilId getBarrilId() {
        return barrilId;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }

    public TipoBarril getTipoBarril() {
        return tipoBarril;
    }

    public Estado getEstado() {
        return estado;
    }
}

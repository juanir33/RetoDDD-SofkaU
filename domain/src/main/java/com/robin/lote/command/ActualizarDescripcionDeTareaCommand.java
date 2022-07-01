package com.robin.lote.command;

import co.com.sofka.domain.generic.Command;
import com.robin.lote.values.LoteId;
import com.robin.lote.values.TareaId;
import com.robin.lote.values.Tiempo;

public class ActualizarDescripcionDeTareaCommand extends Command {
    private final LoteId loteId;
    private final TareaId tareaId;
    private final Tiempo tiempo;

    public ActualizarDescripcionDeTareaCommand(LoteId loteId, TareaId tareaId, Tiempo tiempo) {
        this.loteId = loteId;
        this.tareaId = tareaId;
        this.tiempo = tiempo;
    }

    public LoteId getLoteId() {
        return loteId;
    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }
}

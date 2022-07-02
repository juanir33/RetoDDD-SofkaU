package com.robin.lote.command;

import co.com.sofka.domain.generic.Command;
import com.robin.lote.values.Descripcion;
import com.robin.lote.values.LoteId;
import com.robin.lote.values.TareaId;
import com.robin.lote.values.Tiempo;

public class ActualizarDescripcionDeTareaCommand extends Command {
    private final LoteId loteId;
    private final TareaId tareaId;
    private final Descripcion descripcion;

    public ActualizarDescripcionDeTareaCommand(LoteId loteId, TareaId tareaId, Descripcion descripcion) {
        this.loteId = loteId;
        this.tareaId = tareaId;
        this.descripcion = descripcion;
    }

    public LoteId getLoteId() {
        return loteId;
    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}

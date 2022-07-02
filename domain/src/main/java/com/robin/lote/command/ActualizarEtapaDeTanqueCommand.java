package com.robin.lote.command;

import co.com.sofka.domain.generic.Command;
import com.robin.lote.values.Etapa;
import com.robin.lote.values.LoteId;
import com.robin.lote.values.TanqueId;

public class ActualizarEtapaDeTanqueCommand extends Command {
    private final LoteId loteId;
    private final TanqueId tanqueId;
    private final Etapa etapa;

    public ActualizarEtapaDeTanqueCommand(LoteId loteId, TanqueId tanqueId, Etapa etapa) {
        this.loteId = loteId;
        this.tanqueId = tanqueId;
        this.etapa = etapa;
    }

    public LoteId getLoteId() {
        return loteId;
    }

    public TanqueId getTanqueId() {
        return tanqueId;
    }

    public Etapa getEtapa() {
        return etapa;
    }
}

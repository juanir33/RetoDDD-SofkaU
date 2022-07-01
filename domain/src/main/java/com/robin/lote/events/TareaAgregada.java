package com.robin.lote.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.values.TareaId;
import com.robin.lote.values.TipoTarea;
import com.robin.lote.values.Descripcion;
import com.robin.lote.values.Tiempo;

public class TareaAgregada extends DomainEvent {
    public TareaAgregada(TareaId tareaId, TipoTarea tipoTarea, Descripcion descripcion, Tiempo tiempo) {
        super();
    }
}

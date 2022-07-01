package com.robin.lote;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.lote.events.*;
import com.robin.lote.values.*;


import java.util.*;

public class Lote extends AggregateEvent<LoteId> {
    protected Receta receta;
    protected Tanque tanque;
    protected Set<Tarea> tareas;
    protected BrewmasterId brewmasterId;

    public Lote(LoteId entityId, BrewmasterId brewmasterId) {
        super(entityId);
        this.brewmasterId = brewmasterId;
        appendChange(new LoteCreado(brewmasterId)).apply();
    }

    private Lote(LoteId loteId){
        super(loteId);
        subscribe(new LoteEventChange(this));
    }
    public static Lote from(LoteId loteId, List<DomainEvent> eventList){
        Lote lote = new Lote(loteId);
        eventList.forEach(lote::applyEvent);
        return lote;

    }
    public void agregarTarea(TareaId tareaId, TipoTarea tipoTarea, Descripcion descripcion, Tiempo tiempo){
        appendChange(new TareaAgregada(tareaId, tipoTarea, descripcion, tiempo)).apply();
    }
    public void agregarTanque(TanqueId tanqueId, TipoTanque tipoTanque, Capacidad capacidad) {
        appendChange(new TanqueAgregado(tanqueId, tipoTanque, capacidad)).apply();

    }
    public void agregarReceta(RecetaId entityId, TipoCerveza tipoCerveza, Nombre nombre, Batch batch) {
        appendChange(new RecetaAgregada(entityId, tipoCerveza, batch)).apply();

    }
    public void actualizarEtapaTanque(Etapa etapa){
        appendChange(new EtapaTanqueActualizada(etapa)).apply();
    }
    public void actualizarTiempoTarea(TareaId tareaId, Tiempo tiempo){
        appendChange( new TiempoDeTareaActualizado(tareaId, tiempo)).apply();
    }
    public void actualizarDescripcionTarea(TareaId tareaId, Tiempo tiempo){
        appendChange( new TiempoDeTareaActualizado(tareaId, tiempo)).apply();
    }

    public void actualizarNombreReceta(Nombre nombre){
        appendChange(new NombreRecetaCambiado(nombre)).apply();
    }

    protected Optional<Tarea> getTareaPorId(TareaId tareaId){
        return  tareas().stream().filter(tarea -> tarea.identity().equals(tareaId)).findFirst();

    }

    public BrewmasterId brewmasterId() {
        return brewmasterId;
    }

    public Receta receta() {
        return receta;
    }

    public Set<Tarea> tareas() {
        return tareas;
    }

    public Tanque tanque() {
        return tanque;
    }
}


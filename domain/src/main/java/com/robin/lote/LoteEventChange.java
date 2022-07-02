package com.robin.lote;

import co.com.sofka.domain.generic.EventChange;
import com.robin.lote.events.*;

import java.util.HashSet;

public class LoteEventChange extends EventChange {
    public LoteEventChange(Lote lote) {
        apply((LoteCreado event)->{
            lote.brewmasterId = event.getBrewmasterId();
            lote.tareas= new HashSet<>();
        });
        apply((RecetaAgregada event)->
                lote.receta= new Receta(event.getEntityId(),
                        event.getTipoCerveza(),
                        event.getNombre(),
                        event.getBatch())
        );
        apply((TanqueAgregado event)->
             lote.tanque= new Tanque(event.getTanqueId(),
                     event.getCapacidad(),
                     event.getTipoTanque(),
                     event.getEtapa())
                );
        apply((TareaAgregada event)->{
            var cantidadTareas = lote.tareas().size();
            if(cantidadTareas == 25){throw new IllegalArgumentException("Se permiten hasta 25 tareas por Lote");}
            var nuevaTarea= new Tarea(
                    event.getTareaId(),
                    event.getTipoTarea(),
                    event.getTiempo(),
                    event.getDescripcion());
            lote.tareas.add(nuevaTarea);
        });
        apply((NombreRecetaCambiado event)->{
            if(!lote.receta.nombre().equals(event.getNombre())){
            lote.receta.cambiarNombre(event.getNombre());
        }throw new IllegalArgumentException("El nombre nuevo es igual al actual");
        });
        apply((TiempoDeTareaActualizado event)->{
            var tareaFilter = lote.getTareaPorId(event.getTareaId())
                    .orElseThrow(()->new IllegalArgumentException("La tarea que busca no se encuentra creada"));
            if(tareaFilter.tiempo().equals(event.getTiempo())){
                throw new IllegalArgumentException("El tiempo nuevo es igual al actual");
            } tareaFilter.actualizarTiempo(event.getTiempo());}

        );
        apply((DescripcionDeTareaActualizado event)->{
            var tareaFilter = lote.getTareaPorId(event.getTareaId())
                    .orElseThrow(()->new IllegalArgumentException("La tarea que busca no se encuentra creada"));
            tareaFilter.actualizarDescripcion(event.getDescripcion());

        });
        apply((EtapaTanqueActualizada event)->{
            if(lote.tanque.etapa().equals(event.getEtapa())){
                throw new IllegalArgumentException("La etapa nueva es igual a la actual");
            } lote.tanque.actualizarEtapa(event.getEtapa());

        });
    }
}

package com.robin.logistica;

import co.com.sofka.domain.generic.EventChange;
import com.robin.logistica.events.*;

import java.util.HashSet;
import java.util.Objects;

public class LogisticaEventChange extends EventChange {
    public LogisticaEventChange(Logistica logistica) {
        apply((LogisticaCreada event)->{
           logistica.loteId = event.getLoteId();
           logistica.barriles= new HashSet<>();
        });
        apply((ProtocoloAgregado event)->{
            Objects.requireNonNull(event.getDescripcion());
            Objects.requireNonNull(event.getProtocoloId());
            logistica.protocolo= new Protocolo(event.getProtocoloId(),
                    event.getTipoProtocolo(),
                    event.getDescripcion());
        });
        apply((EncargadoAsignado event)->{
            Objects.requireNonNull(event.getEncargadoId());
            Objects.requireNonNull(event.getArea());
            Objects.requireNonNull(event.getNombre());

            logistica.encargado= new Encargado(event.getEncargadoId(),
                    event.getNombre(),
                    event.getArea());
        });
        apply((BarrilAgregado event)->{
            if(event.getEstado().value().equals("SUCIO")){
                throw new IllegalArgumentException("El barril se encuentra sucio");
            } else if (event.getEstado().value().equals("ENTREGADO")) {
                throw new IllegalArgumentException("El barril se encuentra entregado");
            }else if (event.getEstado().value().equals("LLENO")) {
                throw new IllegalArgumentException("El barril se encuentra lleno");
            }
            logistica.barriles.add(new Barril(event.getBarrilId(),
                    event.getCapacidad(),
                    event.getTipoBarril(),
                    event.getEstado()));

        });
        apply((DescripcionProtocoloActualizada event)->{
            logistica.protocolo.actualizarDescripcionProtocolo(event.getDescripcion());
        });
        apply((EncargadoCambiadoDeArea event)->{
            logistica.encargado.cambiarDeArea(event.getArea());
        });
        apply((EstadoBarrilActualizado event)->{
            var barrilFil = logistica.buscarBarrilPorId(event.getBarrilId())
                    .orElseThrow(()->new IllegalArgumentException("El barril que busca no se encuentra asignado"));
            if(!barrilFil.estado().equals(event.getEstado())){
                barrilFil.actualizarEstado(event.getEstado());
            }throw new IllegalArgumentException("El estado nuevo es igual al actual");

        });
        apply((BarrilEnvasado event)->{
            var barril = logistica.buscarBarrilPorId(event.getBarrilId())
                    .orElseThrow(()->new IllegalArgumentException("El barril que busca no se encuentra asignado"));
            if(barril.estado().value().equals("VACIO")){
                barril.llenarBarril(event.getLoteId());
            }throw new IllegalArgumentException("El barril ya ha sido llenado");
        });


    }
}

package com.robin.logistica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.robin.logistica.events.*;
import com.robin.logistica.values.*;

import com.robin.lote.values.Descripcion;
import com.robin.lote.values.LoteId;
import com.robin.lote.values.Nombre;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Logistica extends AggregateEvent<LogisticaId> {
    protected LoteId loteId;
    protected Set<Barril> barriles;
    protected Encargado encargado;
    protected Protocolo protocolo;
    public Logistica(LogisticaId entityId, LoteId loteId) {
        super(entityId);
        appendChange(new LogisticaCreada(loteId)).apply();
    }

    private Logistica(LogisticaId logisticaId){
        super(logisticaId);
        subscribe(new LogisticaEventChange(this));
    }
    public static Logistica from(LogisticaId logisticaId, List<DomainEvent> list){
        Logistica logistica = new Logistica(logisticaId);
        list.forEach(logistica::applyEvent);
        return logistica;
    }
    public void asignarEncargado(EncargadoId encargadoId, Nombre nombre, Area area){
        appendChange(new EncargadoAsignado(encargadoId, nombre,area)).apply();
    }
    public void agregarProtocolo(ProtocoloId protocoloId,TipoProtocolo tipoProtocolo, Descripcion descripcion){
        appendChange(new ProtocoloAgregado(protocoloId,tipoProtocolo, descripcion)).apply();
    }
    public void agregarBarril(BarrilId barrilId, Capacidad capacidad, TipoBarril tipoBarril, Estado estado){
        appendChange(new BarrilAgregado(barrilId,capacidad, tipoBarril, estado)).apply();
    }
    public void actualizarEstadoDeBarril(BarrilId barrilId, Estado estado){
        appendChange(new EstadoBarrilActualizado(barrilId,estado)).apply();
    }
    public void actualizarDescripcionDelProtocolo(Descripcion descripcion){
        appendChange(new DescripcionProtocoloActualizada(descripcion)).apply();
    }
    public void cambiarDeAreaAencargado(Area area){
        appendChange(new EncargadoCambiadoDeArea(area)).apply();
    }
    public void envasarLote(LoteId loteId, BarrilId barrilId){
        appendChange(new BarrilEnvasado(loteId, barrilId)).apply();
    }
    protected Optional<Barril> buscarBarrilPorId(BarrilId id){
        return barriles().stream().filter(item -> item.identity().equals(id)).findFirst();
    }

    public LoteId loteId() {
        return loteId;
    }

    public Encargado encargado() {
        return encargado;
    }

    public Protocolo protocolo() {
        return protocolo;
    }

    public Set<Barril> barriles() {
        return barriles;
    }
}

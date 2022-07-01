package com.robin.logistica;

import co.com.sofka.domain.generic.Entity;
import com.robin.logistica.values.Area;
import com.robin.logistica.values.EncargadoId;
import com.robin.lote.values.Nombre;



public class Encargado extends Entity<EncargadoId> {

    private Nombre nombre;
    private Area area;

    public Encargado(EncargadoId entityId, Nombre nombre, Area area) {
        super(entityId);
        this.nombre = nombre;
        this.area = area;
    }
    public void cambiarDeArea(Area area){
        this.area = area;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Area area() {
        return area;
    }
}

package com.robin.lote;

import co.com.sofka.domain.generic.Entity;
import com.robin.lote.values.Nombre;
import com.robin.lote.values.RecetaId;
import com.robin.lote.values.TipoCerveza;


import java.util.Objects;

public class Receta extends Entity<RecetaId> {
    private TipoCerveza tipoCerveza;
    private Nombre nombre;
    private Batch batch;

    public Receta(RecetaId entityId, TipoCerveza tipoCerveza, Nombre nombre, Batch batch) {
        super(entityId);
        this.tipoCerveza= tipoCerveza;
        this.nombre = nombre;
        this.batch = batch;
    }
    public void cambiarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Batch batch() {
        return batch;
    }

    public Nombre nombre() {
        return nombre;
    }

    public TipoCerveza tipoCerveza() {
        return tipoCerveza;
    }
}

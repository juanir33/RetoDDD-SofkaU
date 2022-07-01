package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Batch implements ValueObject<Integer> {
    private final Integer volumen;
    public Batch(Integer vol) {
        this.volumen= Objects.requireNonNull(vol, "La capacidad no puede ser nula");
        if(vol <= 5){
            throw new IllegalArgumentException("La capacidad debe ser 5 o mayor");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return volumen.equals(batch.volumen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumen);
    }

    @Override
    public Integer value() {
        return null;
    }
}

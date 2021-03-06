package com.robin.logistica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacidad implements ValueObject<Integer> {
    private final Integer volumen;
    public Capacidad(Integer vol) {
        this.volumen= Objects.requireNonNull(vol, "La capacidad no puede ser nula");
        if(this.volumen < 4 || this.volumen > 60){
            throw new IllegalArgumentException("La capacidad debe estar entre 4 y 60 litros");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capacidad capacidad = (Capacidad) o;
        return volumen.equals(capacidad.volumen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumen);
    }

    @Override
    public Integer value() {
        return volumen;
    }
}

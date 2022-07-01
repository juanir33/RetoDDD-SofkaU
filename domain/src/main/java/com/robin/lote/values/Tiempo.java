package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tiempo implements ValueObject<Integer> {

    private final Integer value;

    public Tiempo(Integer value) {
        this.value = Objects.requireNonNull(value, "Agregue valor valido en Horas");

    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiempo tiempo = (Tiempo) o;
        return value.equals(tiempo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

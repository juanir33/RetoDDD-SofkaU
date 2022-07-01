package com.robin.brewmaster.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ensayo implements ValueObject<String> {
    private final String value;

    public Ensayo(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El ensayo no puede estar vacio");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ensayo ensayo = (Ensayo) o;
        return value.equals(ensayo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}

package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value, "La descripcion no puede ser nula");
        if (value.length() < 4) {
            throw new IllegalArgumentException("La descripcion debe tener mas de 4 caracteres");
        } else if (value.length() > 1000) {
            throw new IllegalArgumentException("Ha excedido el maximo de carcteres permitido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value () {
        return value;
    }


}

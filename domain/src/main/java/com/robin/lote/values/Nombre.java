package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value, "Agregue un nombre");
        if (this.value.length() < 3) {
            throw new IllegalArgumentException("LEl nombre debe tener mas de 3 caracteres");
        } else if (this.value.length() > 20) {
            throw new IllegalArgumentException("Ha excedido el maximo de caracteres permitidos");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return value.equals(nombre.value);
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

package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Etapa implements ValueObject<String> {
    private final String value;

    public Etapa(String value) {
        this.value = Objects.requireNonNull(value, "La etapa no puede ser nula");
        if (value.length() < 3) {
            throw new IllegalArgumentException("La etapa debe tener mas de 3 caracteres");
        } else if (value.length() > 20) {
            throw new IllegalArgumentException("Ha excedido el maximo de caracteres permitidos");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etapa etapa = (Etapa) o;
        return value.equals(etapa.value);
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

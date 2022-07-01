package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoTanque implements ValueObject<String> {
    private final String value;

    public TipoTanque(String value) {
        this.value = Objects.requireNonNull(value, "Por favor agregue un tipo de tanque");
        if (value.length() < 4) {
            throw new IllegalArgumentException(" Debe tener mas de 4 caracteres");
        } else if (value.length() > 20) {
            throw new IllegalArgumentException("Ha excedido el maximo de carcteres permitido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTanque that = (TipoTanque) o;
        return value.equals(that.value);
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

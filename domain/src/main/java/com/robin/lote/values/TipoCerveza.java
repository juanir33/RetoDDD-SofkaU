package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoCerveza implements ValueObject<String> {
    private final String value;

    public TipoCerveza (String value) {
        this.value = Objects.requireNonNull(value, "Por favor agregue un tipo de cerveza");
        if (this.value.length() < 4) {
            throw new IllegalArgumentException(" Debe tener mas de 4 caracteres");
        } else if (this.value.length() > 20) {
            throw new IllegalArgumentException("Ha excedido el maximo de carcteres permitido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCerveza that = (TipoCerveza) o;
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

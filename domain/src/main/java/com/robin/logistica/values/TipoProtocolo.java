package com.robin.logistica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoProtocolo implements ValueObject<String> {
    private final String value;

    public TipoProtocolo(String value) {
        this.value = Objects.requireNonNull(value, "Por favor agregue el tipo de protocolo");
        if (this.value.length() < 4) {
            throw new IllegalArgumentException(" Debe tener mas de 4 caracteres");
        } else if (this.value.length() > 30) {
            throw new IllegalArgumentException("Ha excedido el maximo de carcteres permitido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoProtocolo that = (TipoProtocolo) o;
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

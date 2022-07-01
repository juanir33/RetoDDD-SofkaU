package com.robin.lote.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoTarea implements ValueObject<String> {
    private final String value;

    public TipoTarea(String value) {
        this.value = Objects.requireNonNull(value, "Por favor agregue un tipo de tarea");
        if (this.value.length() < 4) {
            throw new IllegalArgumentException(" Debe tener mas de 4 caracteres");
        } else if (this.value.length() > 40) {
            throw new IllegalArgumentException("Ha excedido el maximo de carcteres permitido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTarea tipoTarea = (TipoTarea) o;
        return value.equals(tipoTarea.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return null;
    }
}

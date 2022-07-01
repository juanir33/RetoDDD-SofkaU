package com.robin.brewmaster.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Usuario implements ValueObject<String> {
    private final String value;

    public Usuario(String value) {
        this.value = Objects.requireNonNull(value, "Agregue un usuario");
        if (value.length() < 3) {
            throw new IllegalArgumentException("Debe tener mas de 3 caracteres");
        } else if (value.length() > 20) {
            throw new IllegalArgumentException("Ha excedido el maximo de caracteres permitidos");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return value.equals(usuario.value);
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

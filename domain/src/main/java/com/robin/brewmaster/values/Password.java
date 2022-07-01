package com.robin.brewmaster.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Password implements ValueObject<String> {
    private final String value;

    public Password(String value) {
        this.value = Objects.requireNonNull(value, "Agregue una contraseña");
        if (this.value.length() < 6 || this.value.length() > 12) {
            throw new IllegalArgumentException(" Debe tener  entre 6 y 12 caracteres");
        }
        if(!value.matches("^(?=.*[0-9])(?=.*[a-z]).{6,12}$")){
            throw new IllegalArgumentException("La contraseña debe tener al menos un numero y una letra");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return value.equals(password.value);
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

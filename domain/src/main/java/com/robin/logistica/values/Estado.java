package com.robin.logistica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado  implements ValueObject<String> {
    private final String value;

    public Estado(String value) {
        this.value = Objects.requireNonNull(value.toUpperCase(), "Por favor agregue un estado");
        if(!(this.value.equals("VACIO")
                || this.value.equals("SUCIO")
                || this.value.equals("LLENO")
                || this.value.equals("ENTREGADO"))){
            throw new IllegalArgumentException("El estado debe ser uno de los siguientes: VACIO, LLENO, SUCIO, ENTREGADO");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return value.equals(estado.value);
    }
    public Estado nuevoEstado(String estado){
        return new Estado(estado);
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

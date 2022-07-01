package com.robin.brewmaster.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Vencimiento implements ValueObject<String> {
     private final String fechaVencimiento;

    public Vencimiento(String fechaVencimiento) {
        this.fechaVencimiento = Objects.requireNonNull(fechaVencimiento);
        if(fechaVencimiento.equals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd,MM,yyyy")))){
            throw new IllegalArgumentException("Ingrese una fecha distinta a la actual");
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vencimiento that = (Vencimiento) o;
        return fechaVencimiento.equals(that.fechaVencimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaVencimiento);
    }

    @Override
    public String value() {
        return fechaVencimiento;
    }
}

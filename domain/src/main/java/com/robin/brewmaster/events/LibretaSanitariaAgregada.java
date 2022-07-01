package com.robin.brewmaster.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.robin.brewmaster.values.LibretaSanitariaId;
import com.robin.brewmaster.values.Vencimiento;

public class LibretaSanitariaAgregada extends DomainEvent {
    private final LibretaSanitariaId libretaSanitariaId;
    private final Vencimiento vencimiento;

    public LibretaSanitariaAgregada(LibretaSanitariaId libretaSanitariaId, Vencimiento vencimiento) {
        super("robin.brewmaster.LibretaSanitariaAgregada");
        this.libretaSanitariaId = libretaSanitariaId;
        this.vencimiento = vencimiento;
    }

    public LibretaSanitariaId getLibretaSanitariaId() {
        return libretaSanitariaId;
    }

    public Vencimiento getVencimiento() {
        return vencimiento;
    }
}

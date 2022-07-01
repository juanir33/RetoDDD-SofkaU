package com.robin.logistica.values;

import co.com.sofka.domain.generic.Identity;

public class LogisticaId extends Identity {
    public LogisticaId(String uuid) {
        super(uuid);
    }

    public LogisticaId() {
    }

    public static LogisticaId of(String uuid){
        return  new LogisticaId(uuid);
    }
}

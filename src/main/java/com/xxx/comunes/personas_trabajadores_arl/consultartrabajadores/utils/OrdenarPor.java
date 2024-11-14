package com.xxxxxxxx.comunes.personas_trabajadores_arl.consultartrabajadores.utils;

import org.springframework.http.HttpStatus;

public enum OrdenarPor {
    DOCTIPO("DOCTIPO"),
    NIT("NIT"),
    DESCTIPOCOTIZANTE("CODTIPOCOTIZANTE"),
    DESCENTROTRABAJO("CENTROTRABAJO"),
    INICOBERTURA("INICOBERTURA"),
    FINCOBERTURA("FINCOBERTURA"),
    ESTADO("ESTADO");

    private final String value;
    OrdenarPor(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}

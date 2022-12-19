package com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.utils;

public enum Direccion {
    ASC("ASC"),DESC("DESC");

    private final String value;

    Direccion(String value) {
        this.value = value;
    }
    public String value() {
        return this.value;
    }
}

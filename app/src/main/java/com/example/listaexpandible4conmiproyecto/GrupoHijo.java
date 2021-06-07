package com.example.listaexpandible4conmiproyecto;

class GrupoHijo {
    // Variables gasto.
    private final float montoHijo;
    private final String descripcionHijo;
    private final String fechaHijo;

    // Constructores.
    public GrupoHijo(float montoHijo, String descripcionHijo, String fechaHijo) {
        this.montoHijo = montoHijo;
        this.descripcionHijo = descripcionHijo;
        this.fechaHijo = fechaHijo;
    }

    // RETORNAMOS los valores.
    public float getMontoHijo() {
        return montoHijo;
    }

    public String getDescripcionHijo() {
        return descripcionHijo;
    }

    public String getFechaHijo() {
        return fechaHijo;
    }
}

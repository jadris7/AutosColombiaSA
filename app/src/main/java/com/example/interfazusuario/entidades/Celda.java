package com.example.interfazusuario.entidades;

public class Celda {

    private String idCelda;
    private String nombre;

    public Celda(){

    }
    public Celda(String idCelda, String nombre) {
        this.idCelda = idCelda;
        this.nombre = nombre;
    }

    public String getIdCelda() {
        return idCelda;
    }

    public void setIdCelda(String idCelda) {
        this.idCelda = idCelda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package com.example.interfazusuario.entidades;

public class Vehiculo {
    private String idPlaca;
    private String marca;
    private String modelo;
    private String color;
    private String idPropietario;
    private String id_celda;

    public Vehiculo(){

    }

    public Vehiculo(String idPlaca, String marca, String modelo, String color, String idPropietario, String id_celda) {
        this.idPlaca = idPlaca;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.idPropietario = idPropietario;
        this.id_celda = id_celda;
    }

    public String getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(String idPlaca) {
        this.idPlaca = idPlaca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getId_celda() {
        return id_celda;
    }

    public void setId_celda(String id_celda) {
        this.id_celda = id_celda;
    }
}

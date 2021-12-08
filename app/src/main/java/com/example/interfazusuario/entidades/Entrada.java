package com.example.interfazusuario.entidades;

import java.io.Serializable;
import java.util.Date;

public class Entrada implements Serializable {

    private String idPlaca;
    private String fecha;
    private String comentario;

    public Entrada(){

    }

    public Entrada(String idPlaca, String fecha, String comentario) {
        this.idPlaca = idPlaca;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public String getIdPlaca() {
        return idPlaca;
    }

    public void setIdPlaca(String idPlaca) {
        this.idPlaca = idPlaca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

package com.example.interfazusuario.entidades;

public class Usuario {

    private String email;
    private String clave;

    public Usuario(){

    }

    public Usuario(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

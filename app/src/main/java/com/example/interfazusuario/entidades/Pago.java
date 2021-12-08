package com.example.interfazusuario.entidades;

import java.util.Date;

public class Pago {
    private Integer idPago;
    private String placa;
    private String idPropietario;
    private String NombrePropietario;
    private Date fechaPago;
    private String mesPagado;
    private String valor = "80000";

    public Pago(){

    }

    public Pago(Integer idPago, String placa, String idPropietario, String NombrePropietario, Date fechaPago, String mesPagado, String valor) {
        this.idPago = idPago;
        this.placa = placa;
        this.idPropietario = idPropietario;
        this.NombrePropietario = NombrePropietario;
        this.fechaPago = fechaPago;
        this.mesPagado = mesPagado;
        this.valor = valor;
    }

    public String getNombrePropietario() {
        return NombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        NombrePropietario = nombrePropietario;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMesPagado() {
        return mesPagado;
    }

    public void setMesPagado(String mesPagado) {
        mesPagado = mesPagado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}


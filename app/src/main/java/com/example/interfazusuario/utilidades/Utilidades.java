package com.example.interfazusuario.utilidades;

import java.util.Date;

public class Utilidades {


    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_CLAVE = "clave";

    public static final String CREAR_TABLA_USUARIO= "CREATE TABLE "
            +TABLA_USUARIO + " ("
            +CAMPO_EMAIL+" TEXT PRIMARY KEY, "
            +CAMPO_CLAVE+" TEXT NOT NULL)";


    //Constantes campos tabla propietario
    public static final String TABLA_PROPIETARIO = "propietario";
    public static final String CAMPO_CEDULA = "cedula";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";
    public static final String CAMPO_TELEFONO = "telefono";
    public static final String CAMPO_DIRECCION = "direccion";
    public static final String CAMPO_CORREO = "email";

    public static final String CREAR_TABLA_PROPIETARIO= "CREATE TABLE "
            +TABLA_PROPIETARIO + " ("
            +CAMPO_CEDULA+" TEXT PRIMARY KEY, "
            +CAMPO_NOMBRE+" TEXT NOT NULL, "
            +CAMPO_APELLIDO+" TEXT , "
            +CAMPO_TELEFONO+" TEXT NOT NULL, "
            +CAMPO_DIRECCION+" TEXT , "
            +CAMPO_CORREO+" TEXT )";


    //Constantes campos tabla vehículo
    public static final String TABLA_VEHICULO = "vehiculo";
    public static final String CAMPO_ID_PLACA = "idPlaca";
    public static final String CAMPO_MARCA = "marca";
    public static final String CAMPO_MODELO = "modelo";
    public static final String CAMPO_COLOR = "color";
    public static final String CAMPO_ID_PROPIETARIO= "idPropietario";
    public static final String CAMPO_ID_CELDA = "id_celda";

    public static final String CREAR_TABLA_VEHICULO="CREATE TABLE "
            +TABLA_VEHICULO + " ("
            +CAMPO_ID_PLACA+" TEXT PRIMARY KEY, "
            +CAMPO_MARCA+" TEXT , "
            +CAMPO_MODELO+" TEXT , "
            +CAMPO_COLOR+" TEXT , "
            +CAMPO_ID_PROPIETARIO+" TEXT , "
            +CAMPO_ID_CELDA+" TEXT)";


    //Constantes campos tabla celda
    public static final String TABLA_CELDA = "celda";
    public static final String CAMPO_IDCELDA = "idCelda";
    public static final String CAMPO_NOMBRE_CELDA = "nombre";

    public static final String CREAR_TABLA_CELDA="CREATE TABLE "
            +TABLA_CELDA + " ("
            +CAMPO_IDCELDA+" TEXT PRIMARY KEY, "
            +CAMPO_NOMBRE_CELDA+" TEXT)";

    //Constantes campos tabla Pago
    public static final String TABLA_PAGO = "pago";
    public static final String CAMPO_IDPAGO = "idPago";
    public static final String CAMPO_PLACA = "placa";
    public static final String CAMPO_ID_PROPIET = "idPropietario";
    public static final String CAMPO_NOMBRE_PROPIETARIO = "NombrePropietario";
    public static final String CAMPO_FECHA_PAGO = "fechaPago";
    public static final String CAMPO_MES_PAGADO = "MesPagado";
    public static final String CAMPO_VALOR = "valor";

    public static final String CREAR_TABLA_PAGO= "CREATE TABLE "
            +TABLA_PAGO + " ("
            +CAMPO_IDPAGO+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_PLACA+" TEXT NOT NULL, "
            +CAMPO_ID_PROPIET+" TEXT , "
            +CAMPO_NOMBRE_PROPIETARIO+" TEXT, "
            +CAMPO_FECHA_PAGO+" DATE , "
            +CAMPO_MES_PAGADO+" TEXT , "
            +CAMPO_VALOR+" DOUBLE)";

    //Constantes campos tabla Ingreso
    public static final String TABLA_INGRESO = "ingreso";
    public static final String CAMPO_IDPLACAING = "idPlaca";
    public static final String CAMPO_FECHAING = "fecha";
    public static final String CAMPO_COMENTARIOING = "comentario";

    public static final String CREAR_TABLA_INGRESO="CREATE TABLE "
            +TABLA_INGRESO + " ("
            +CAMPO_IDPLACAING+" TEXT PRIMARY KEY, "
            +CAMPO_FECHAING+" INTEGER , "
            +CAMPO_COMENTARIOING+" TEXT)";

    //Constantes campos tabla Salida
    public static final String TABLA_SALIDA = "salida";
    public static final String CAMPO_IDPLACASAL = "idPlaca";
    public static final String CAMPO_FECHASAL = "fecha";
    public static final String CAMPO_COMENTARIOSAL = "comentario";

    public static final String CREAR_TABLA_SALIDA="CREATE TABLE "
            +TABLA_SALIDA + " ("
            +CAMPO_IDPLACASAL+" TEXT PRIMARY KEY, "
            +CAMPO_FECHASAL+" INTEGER , "
            +CAMPO_COMENTARIOSAL+" TEXT)";
}

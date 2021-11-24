package com.example.interfazusuario.utilidades;

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
}

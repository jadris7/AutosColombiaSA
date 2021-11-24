package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interfazusuario.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    EditText cedula, nombre, apellido, direccion, telefono, email;
    Button Registrar, Regresar, Consultar, Eliminar, Actualizar, Salir;
    String Title = "Gestión Propietario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Salir = findViewById(R.id.btnSalir);
        cedula = findViewById(R.id.txtDocumento);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        telefono = findViewById(R.id.txtCelular);
        email = findViewById(R.id.txtEmail);
        direccion = findViewById(R.id.txtDireccion);
        Registrar = findViewById(R.id.btnRegistrar);
        Regresar = findViewById(R.id.btnRegresar);
        Consultar = findViewById(R.id.btnConsultar);
        Actualizar = findViewById(R.id.btnActualizar);
        Eliminar = findViewById(R.id.btnEliminar);

        this.setTitle(Title);

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrar();
            }
        });

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });

        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salir();
            }
        });
    }
    public void Registrar(){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Utilidades.CAMPO_CEDULA, cedula.getText().toString());
        registro.put(Utilidades.CAMPO_NOMBRE, nombre.getText().toString());
        registro.put(Utilidades.CAMPO_APELLIDO, apellido.getText().toString());
        registro.put(Utilidades.CAMPO_TELEFONO, telefono.getText().toString());
        registro.put(Utilidades.CAMPO_CORREO, email.getText().toString());
        registro.put(Utilidades.CAMPO_DIRECCION, direccion.getText().toString());

        db.insert(Utilidades.TABLA_PROPIETARIO,Utilidades.CAMPO_CEDULA, registro);

        if(cedula.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"El campo cedula está vacio", Toast.LENGTH_LONG).show();
        }else {
            if (nombre.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "El campo nombre está vacio", Toast.LENGTH_LONG).show();
            } else {
                if (apellido.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "El campo apellido está vacio", Toast.LENGTH_LONG).show();
                } else {
                    if (telefono.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "El campo teléfono está vacio", Toast.LENGTH_LONG).show();
                    } else {
                        if (email.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "El campo email está vacio", Toast.LENGTH_LONG).show();
                        } else {
                            if (direccion.getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "El campo dirección está vacio", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, "Registro éxitoso!!!", Toast.LENGTH_LONG).show();
                                cedula.setText("");
                                nombre.setText("");
                                apellido.setText("");
                                telefono.setText("");
                                email.setText("");
                                direccion.setText("");
                            }
                        }
                    }
                }
            }
        }
        db.close();
    }

    public void Regresar(){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void Consultar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getReadableDatabase();
        String [] ced = {cedula.getText().toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_APELLIDO, Utilidades.CAMPO_TELEFONO, Utilidades.CAMPO_DIRECCION, Utilidades.CAMPO_EMAIL};

        try {
            Cursor respuesta = db.query(Utilidades.TABLA_PROPIETARIO, campos, Utilidades.CAMPO_CEDULA +"=?", ced,null,null,null);
            respuesta.moveToFirst();
            nombre.setText(respuesta.getString(0));
            telefono.setText(respuesta.getString(2));
            email.setText(respuesta.getString(4));
            direccion.setText(respuesta.getString(3));
            apellido.setText(respuesta.getString(1));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El propietario no existe", Toast.LENGTH_LONG).show();
            nombre.setText("");
            telefono.setText("");
            email.setText("");
            direccion.setText("");
            apellido.setText("");
            cedula.setText("");
        }

        db.close();
    }


    public void Eliminar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String [] ced = {cedula.getText().toString()};

        int cant =  db.delete(Utilidades.TABLA_PROPIETARIO, Utilidades.CAMPO_CEDULA+"=?", ced);

        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        email.setText("");
        direccion.setText("");
        if (cant == 1){
            Toast.makeText(this, "Propietario eliminado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "El propietario no existe", Toast.LENGTH_LONG).show();
        }
        db.close();

    }

    public void Actualizar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String [] ced = {cedula.getText().toString()};

        ContentValues registros = new ContentValues();
        registros.put(Utilidades.CAMPO_NOMBRE, nombre.getText().toString());
        registros.put(Utilidades.CAMPO_APELLIDO, apellido.getText().toString());
        registros.put(Utilidades.CAMPO_TELEFONO, telefono.getText().toString());
        registros.put(Utilidades.CAMPO_CORREO, email.getText().toString());
        registros.put(Utilidades.CAMPO_DIRECCION, direccion.getText().toString());

        int cant = db.update(Utilidades.TABLA_PROPIETARIO, registros,Utilidades.CAMPO_CEDULA+"=?", ced);

        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        email.setText("");
        direccion.setText("");

        if (cant == 1){
            Toast.makeText(this, "Datos Actualizados", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "El propietario no existe", Toast.LENGTH_LONG).show();
        }
        db.close();
    }

    public void Salir() {
        finish();
    }
}
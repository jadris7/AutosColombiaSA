package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interfazusuario.utilidades.Utilidades;

public class RegistroActivity extends AppCompatActivity {

    EditText campoEmail, campoClave;
    Button Registrar, Regresar;
    String Title = "Registro de Usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        campoEmail = findViewById(R.id.txtEmail);
        campoClave = findViewById(R.id.txtClave);
        Registrar = findViewById(R.id.btnRegistrar);
        Regresar = findViewById(R.id.btnRegresar);

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
    }


    public void Registrar(){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);

        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_EMAIL, campoEmail.getText().toString());
        values.put(Utilidades.CAMPO_CLAVE,campoClave.getText().toString());

         db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_EMAIL, values);

        if (campoEmail.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"El campo email está vacio", Toast.LENGTH_LONG).show();
        }else{
            if (campoClave.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"El campo contraseña está vacio", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Registro éxitoso!!!", Toast.LENGTH_SHORT).show();
                campoEmail.setText("");
                campoClave.setText("");
            }
        }
        db.close();
    }

    public void Regresar(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
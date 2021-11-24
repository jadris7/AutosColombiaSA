package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interfazusuario.utilidades.Utilidades;

public class LoginActivity extends AppCompatActivity {

    EditText email, clave;
    Button Registrar, Ingresar;
    String Title = "Inicio de Sesión";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle(Title);
        email = findViewById(R.id.txtEmail);
        clave = findViewById(R.id.txtClave);
        Registrar = findViewById(R.id.btnRegistrarUsuario);
        Ingresar = findViewById(R.id.btnIngresarLogin);

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrar();
            }
        });

        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ingresar();
            }
        });
    }
    public void Ingresar(){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String correo = email.getText().toString();
        String password = clave.getText().toString();
        Cursor respuesta = db.rawQuery("select email, clave from usuario where email='"+correo+"'and clave ='"+password+"'",null);
        if(respuesta.moveToFirst()){
            Intent intent = new Intent(this,MenuActivity.class);
            startActivity(intent);
            email.setText("");
            clave.setText("");
        }else{
            Toast.makeText(getApplicationContext(), "Usuario y/o Contraseña inválidos", Toast.LENGTH_SHORT).show();
        } db.close();

    }

    public void Registrar(){
        Intent intent = new Intent(this,RegistroActivity.class);
        startActivity(intent);
    }
}
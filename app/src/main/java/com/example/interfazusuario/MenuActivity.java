package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button IngresarCliente, IngresarVehiculo, RegresarLogin, IngresarPagos, IngresarCelda, IngresarNovedad;
    String Title = "Menú";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        IngresarCliente = findViewById(R.id.btnCliente);
        IngresarVehiculo = findViewById(R.id.btnVehiculos);
        IngresarNovedad= findViewById(R.id.btnNovedad);
        IngresarPagos= findViewById(R.id.btnPago);
        IngresarCelda = findViewById(R.id.btnGestionCelda);
        RegresarLogin = findViewById(R.id.btnRegresar);

        this.setTitle(Title);

        IngresarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngresarCliente();
            }
        });

        RegresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegresarLogin();
            }
        });
        IngresarVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { IngresarVehiculo(); }
        });

        IngresarCelda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { IngresarCelda(); }
        });

    }

    public void IngresarCliente(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void IngresarVehiculo(){
        Intent intent = new Intent(this,VehiculoActivity.class);
        startActivity(intent);
    }
    public void RegresarLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    public void IngresarCelda() {
        Intent intent = new Intent(this,CeldaActivity.class);
        startActivity(intent);
    }
}

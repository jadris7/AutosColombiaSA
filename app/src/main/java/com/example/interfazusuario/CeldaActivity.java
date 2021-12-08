package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CeldaActivity extends AppCompatActivity {

    String Title = "Gestión de Celdas";
    Button Regresar, Salir, habilitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celda);
        Salir = findViewById(R.id.btnSalir);
        Regresar = findViewById(R.id.btnRegresar);

        this.setTitle(Title);

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

    public void Regresar(){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void Salir() {
        finish();
    }

}
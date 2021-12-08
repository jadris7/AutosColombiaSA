package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interfazusuario.utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NovedadActivity extends AppCompatActivity{
    String Title = "Gestión de Novedades";
    EditText placa, comentario;
    Calendar calendar;
    Button Regresar, Salir, Ingresar, Retirar, ConsultarEntrada, ConsultarSalida;
    TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novedad);
        fecha = findViewById(R.id.txtFecha);
        placa = findViewById(R.id.txtPlaca);
        comentario = findViewById(R.id.txtComentario);
        Regresar = findViewById(R.id.btnRegresar);
        Salir = findViewById(R.id.btnSalir);
        Ingresar = findViewById(R.id.btnIngreso);
        Retirar = findViewById(R.id.btnSalida);
        ConsultarEntrada = findViewById(R.id.btnConsultar);
        ConsultarSalida = findViewById(R.id.btnConsultarSalida);
        this.setTitle(Title);
        Date date = new Date();

        //Obtener Fecha y hora
        SimpleDateFormat f = new SimpleDateFormat("dd'/'MM'/'yyyy h:mm a", Locale.getDefault());
        String sfecha = f.format(date);
        fecha.setText(sfecha);

        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarNovedad();
            }
        });

        Retirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retirarNovedad();
            }
        });

        ConsultarEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarNovedadEntrada();
            }
        });

        ConsultarSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarNovedadSalida();
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
    public void Regresar(){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void consultarNovedadEntrada(){
        Intent intent = new Intent(this,ConsultarNovedadActivity.class);
        startActivity(intent);
    }

    public void consultarNovedadSalida(){
        Intent intent = new Intent(this,ConsultarNovedadSalidaActivity.class);
        startActivity(intent);
    }

    public void Salir() {
        finish();
    }

    public void registrarNovedad(){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);

        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_IDPLACAING, placa.getText().toString());
        values.put(Utilidades.CAMPO_FECHAING, fecha.getText().toString());
        values.put(Utilidades.CAMPO_COMENTARIOING,comentario.getText().toString());

        db.insert(Utilidades.TABLA_INGRESO,Utilidades.CAMPO_IDPLACAING, values);

        if (placa.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"El campo placa está vacio", Toast.LENGTH_LONG).show();
        }else{
            if (comentario.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"El campo comentario está vacio", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Novedad de Ingreso Registrada exitosamente!!!", Toast.LENGTH_SHORT).show();
                placa.setText("");
                comentario.setText("");
            }
        }
        db.close();
    }

    public void retirarNovedad(){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);

        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_IDPLACAING, placa.getText().toString());
        values.put(Utilidades.CAMPO_FECHAING, fecha.getText().toString());
        values.put(Utilidades.CAMPO_COMENTARIOING,comentario.getText().toString());

        db.insert(Utilidades.TABLA_SALIDA,Utilidades.CAMPO_IDPLACAING, values);

        if (placa.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"El campo placa está vacio", Toast.LENGTH_LONG).show();
        }else{
            if (comentario.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"El campo comentario está vacio", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Novedad de Salida Registrada exitosamente!!!", Toast.LENGTH_SHORT).show();
                placa.setText("");
                comentario.setText("");
            }
        }
        db.close();
    }

}
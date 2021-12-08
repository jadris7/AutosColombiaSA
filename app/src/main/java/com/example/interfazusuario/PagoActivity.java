package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interfazusuario.entidades.Propietario;
import com.example.interfazusuario.utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PagoActivity extends AppCompatActivity {
    EditText placa, valor;
    TextView fecha;
    Button Pagar, Cancelar, Regresar, Salir;
    String Title = "Gestión de Pagos";
    Spinner comboPago, comboPropietario;
    ArrayList<String> listaPropietarios;
    ArrayList<Propietario> propietarioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        placa = findViewById(R.id.txtPlaca);
        comboPago= (Spinner) findViewById(R.id.spinner_mes);
        fecha = findViewById(R.id.txtFecha);
        valor = findViewById(R.id.txtValor);
        Pagar = (Button)findViewById(R.id.btnPago);
        Regresar = findViewById(R.id.btnRegresar);
        Cancelar = findViewById(R.id.btnCancelar);
        Salir = findViewById(R.id.btnSalir);
        comboPropietario= (Spinner) findViewById(R.id.comboPropietario);

        this.setTitle(Title);

        Date date = new Date();

        //Obtener Fecha y hora
        SimpleDateFormat f = new SimpleDateFormat("dd'/'MM'/'yyyy h:mm a", Locale.getDefault());
        String sfecha = f.format(date);
        fecha.setText(sfecha);

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regresar();
            }
        });

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.mes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        comboPago.setAdapter(adapter);

        consultarPropietario();
        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter
                (this,android.R.layout.simple_spinner_item,listaPropietarios);

        comboPropietario.setAdapter(adaptador);



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

    public void realizarPago(View view){
        Toast.makeText(getApplicationContext(), "Pago Registrado Exitosamente!!!", Toast.LENGTH_LONG).show();
        placa.setText("");
        valor.setText("");
        fecha.setText("");
        comboPago.setSelection(0);
        comboPropietario.setSelection(0);
    }


    public void Regresar(){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void Salir() {
        finish();
    }

    private void consultarPropietario(){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Propietario propietario = null;
        propietarioList = new ArrayList<Propietario>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PROPIETARIO,null);

        while (cursor.moveToNext()) {
            propietario = new Propietario();
            propietario.setCedula(cursor.getString(0));
            propietario.setNombre(cursor.getString(1));
            propietario.setApellido(cursor.getString(2));

            propietarioList.add(propietario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaPropietarios=new ArrayList<String>();
        listaPropietarios.add("propietario");

        for(int i=0;i<propietarioList.size();i++){
            listaPropietarios.add(propietarioList.get(i).getCedula()+" - "+propietarioList.get(i).getNombre()+" - "+propietarioList.get(i).getApellido());
        }
    }
}
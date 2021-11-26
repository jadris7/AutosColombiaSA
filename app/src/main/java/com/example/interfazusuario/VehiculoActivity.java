package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;
import android.util.Log;
import com.example.interfazusuario.entidades.Propietario;
import com.example.interfazusuario.utilidades.Utilidades;

import java.util.ArrayList;

public class VehiculoActivity extends AppCompatActivity {
    EditText placa, marca, modelo, color, idCelda;
    Button Registrar, Regresar, Consultar, Eliminar, Actualizar, Salir;
    String Title = "VEHÍCULOS";

    Spinner comboPropietario;
    ArrayList<String> listaPropietarios;
    ArrayList<Propietario> propietarioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);
        Salir = findViewById(R.id.btnSalir);
        placa = findViewById(R.id.txtPlaca);
        marca = findViewById(R.id.txtMarca);
        modelo = findViewById(R.id.txtModelo);
        color = findViewById(R.id.txtColor);
        idCelda = findViewById(R.id.txtCelda);
        //idPropietario = findViewById(R.id.txtPropietario);
        Registrar = findViewById(R.id.btnRegistrar);
        Regresar = findViewById(R.id.btnRegresar);
        Consultar = findViewById(R.id.btnConsultar);
        Actualizar = findViewById(R.id.btnActualizar);
        Eliminar = findViewById(R.id.btnEliminar);
        comboPropietario= (Spinner) findViewById(R.id.comboPropietario);

        this.setTitle(Title);

        consultarPropietario();
        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter
                (this,android.R.layout.simple_spinner_item,listaPropietarios);

        comboPropietario.setAdapter(adaptador);


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
        registro.put(Utilidades.CAMPO_ID_PLACA, placa.getText().toString());
        registro.put(Utilidades.CAMPO_MARCA, marca.getText().toString());
        registro.put(Utilidades.CAMPO_MODELO, modelo.getText().toString());
        registro.put(Utilidades.CAMPO_COLOR, color.getText().toString());
        registro.put(Utilidades.CAMPO_ID_CELDA, idCelda.getText().toString());
        //registro.put(Utilidades.CAMPO_ID_PROPIETARIO, idPropietario.getText().toString());

        int idCombo = (int)comboPropietario.getSelectedItemId();
        if (idCombo!=0){
            Log.i("TAMAÑO",propietarioList.size()+"");
            Log.i("id combo",idCombo+"");
            Log.i("id combo - 1",(idCombo-1)+"");//se resta 1 ya que se quiere obtener la posicion de la lista, no del combo
            String cedPropietario=propietarioList.get(idCombo-1).getCedula().toString();
            Log.i("id DUEÑO",cedPropietario+"");

            registro.put(Utilidades.CAMPO_ID_PROPIETARIO,cedPropietario);
            Long idResultante=db.insert(Utilidades.TABLA_VEHICULO,Utilidades.CAMPO_ID_PLACA, registro);

            if(placa.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"El campo placa está vacio", Toast.LENGTH_LONG).show();
            }else {
                if (marca.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "El campo marca está vacio", Toast.LENGTH_LONG).show();
                } else {
                    if (modelo.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "El campo modelo está vacio", Toast.LENGTH_LONG).show();
                    } else {
                        if (color.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "El campo color está vacio", Toast.LENGTH_LONG).show();
                        } else {
                            if (idCelda.getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "El campo Celda está vacio", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, "Vehiculo Registrado Exitosamente!!!", Toast.LENGTH_LONG).show();
                                placa.setText("");
                                marca.setText("");
                                modelo.setText("");
                                color.setText("");
                                idCelda.setText("");
                                comboPropietario.setSelection(0);
                            }
                        }
                    }
                }
            }

        }else{
            Toast.makeText(getApplicationContext(),"Debe seleccionar un Propietario",Toast.LENGTH_LONG).show();
        }

        db.close();
    }

    public void Regresar(){
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void Consultar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String [] pla = {placa.getText().toString()};
        String [] campos = {Utilidades.CAMPO_MARCA, Utilidades.CAMPO_MODELO, Utilidades.CAMPO_COLOR, Utilidades.CAMPO_ID_CELDA, Utilidades.CAMPO_ID_PROPIETARIO};

        try {
            Cursor respuesta = db.query(Utilidades.TABLA_VEHICULO, campos, Utilidades.CAMPO_ID_PLACA +"=?", pla,null,null,null);
            respuesta.moveToFirst();
            marca.setText(respuesta.getString(0));
            modelo.setText(respuesta.getString(1));
            color.setText(respuesta.getString(2));
            idCelda.setText(respuesta.getString(3));
           // idPropietario.setText(respuesta.getString(4));
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El vehículo no existe", Toast.LENGTH_LONG).show();
            placa.setText("");
            marca.setText("");
            modelo.setText("");
            color.setText("");
            idCelda.setText("");
            comboPropietario.setSelection(0);
        }
        db.close();
    }

    public void Eliminar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String [] pla = {placa.getText().toString()};

        int cant =  db.delete(Utilidades.TABLA_VEHICULO, Utilidades.CAMPO_ID_PLACA+"=?", pla);
        placa.setText("");
        marca.setText("");
        modelo.setText("");
        color.setText("");
        idCelda.setText("");
        comboPropietario.setSelection(0);
        if (cant == 1){
            Toast.makeText(this, "Vehículo eliminado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "El vehículo no existe", Toast.LENGTH_LONG).show();
        }
        db.close();

    }

    public void Actualizar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String [] pla = {placa.getText().toString()};

        ContentValues registro = new ContentValues();
        registro.put(Utilidades.CAMPO_MARCA, marca.getText().toString());
        registro.put(Utilidades.CAMPO_MODELO, modelo.getText().toString());
        registro.put(Utilidades.CAMPO_COLOR, color.getText().toString());
        registro.put(Utilidades.CAMPO_ID_CELDA, idCelda.getText().toString());
        //registro.put(Utilidades.CAMPO_ID_PROPIETARIO, idPropietario.getText().toString());

        int cant = db.update(Utilidades.TABLA_VEHICULO, registro,Utilidades.CAMPO_ID_PLACA+"=?", pla);

        placa.setText("");
        marca.setText("");
        modelo.setText("");
        color.setText("");
        idCelda.setText("");
        comboPropietario.setSelection(0);

        if (cant == 1){
            Toast.makeText(this, "Datos Actualizados", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "El Vehículo no existe", Toast.LENGTH_LONG).show();
        }

        db.close();

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
        listaPropietarios.add("Seleccione");

        for(int i=0;i<propietarioList.size();i++){
            listaPropietarios.add(propietarioList.get(i).getCedula()+" - "+propietarioList.get(i).getNombre()+" - "+propietarioList.get(i).getApellido());
        }
    }

    public void Salir() {
        finish();
    }
}
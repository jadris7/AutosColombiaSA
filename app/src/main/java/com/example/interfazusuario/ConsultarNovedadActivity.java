package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.interfazusuario.entidades.Entrada;
import com.example.interfazusuario.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarNovedadActivity extends AppCompatActivity {
    String Title = "Novedades de Entrada";
    ListView listViewVehiculo;
    ArrayList<String> listaInformacion;
    ArrayList<Entrada> listaVehiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_novedad);
        listViewVehiculo= (ListView) findViewById(R.id.listViewVehiculo);
        this.setTitle(Title);
        consultarNovedad();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewVehiculo.setAdapter(adaptador);

    }

    private void consultarNovedad() {
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Entrada ingre=null;
        listaVehiculos=new ArrayList<Entrada>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_INGRESO,null);

        while (cursor.moveToNext()){
            ingre = new Entrada();
            ingre.setIdPlaca(cursor.getString(0));
            ingre.setFecha(cursor.getString(1));
            ingre.setComentario(cursor.getString(2));

            listaVehiculos.add(ingre);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaVehiculos.size();i++){
            listaInformacion.add("\n"+"Placa: "+listaVehiculos.get(i).getIdPlaca()+"\n"
                    +"Fecha: "+listaVehiculos.get(i).getFecha()+"\n"
                    +"Comentario: "+listaVehiculos.get(i).getComentario()+"\n");
        }

    }
}

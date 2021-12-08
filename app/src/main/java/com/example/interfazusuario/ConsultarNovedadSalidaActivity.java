package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.interfazusuario.entidades.Entrada;
import com.example.interfazusuario.entidades.Salida;
import com.example.interfazusuario.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarNovedadSalidaActivity extends AppCompatActivity {

    String Title = "Novedades de Salida";
    ListView listViewVehiculo;
    ArrayList<String> listaInformacion;
    ArrayList<Salida> listaVehiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_novedad_salida);

        listViewVehiculo= (ListView) findViewById(R.id.listViewVehiculo);
        this.setTitle(Title);
        consultarNovedad();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewVehiculo.setAdapter(adaptador);

    }

    private void consultarNovedad() {
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "Sistemas",null,1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Salida salida=null;
        listaVehiculos=new ArrayList<Salida>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_SALIDA,null);

        while (cursor.moveToNext()){
            salida = new Salida();
            salida.setIdPlaca(cursor.getString(0));
            salida.setFecha(cursor.getString(1));
            salida.setComentario(cursor.getString(2));

            listaVehiculos.add(salida);
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
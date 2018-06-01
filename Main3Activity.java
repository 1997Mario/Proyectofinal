package com.example.mariomarcillo.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mariomarcillo.proyecto.models.Adapter_Generalidades;
import com.example.mariomarcillo.proyecto.models.Generalidades;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    List<Generalidades> data;
    Adapter_Generalidades adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        list= (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);
        // peliculas=getResources().getStringArray(R.array.Pelicula);
        data= new ArrayList<>();
        adapter= new Adapter_Generalidades(this,data);
        list.setAdapter(adapter);

        loadPeliculas();
    }

    private void loadPeliculas() {
        String textop1 = getResources().getString(R.string.texto1);
        Generalidades p1 =  new Generalidades();
        p1.setNombre("Volcán Galeras");
        p1.setDescripcion(textop1);
        p1.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/VolcanGaleras/PublishingImages/Paginas/default/volcanGaleras.jpg");

        String textop2 = getResources().getString(R.string.texto2);
        Generalidades p2 =  new Generalidades();
        p2.setNombre("Volcán Azufral");
        p2.setDescripcion(textop2);
        p2.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/VolcanAzufral/PublishingImages/Paginas/generalidades/azufral1.png");

        String textop3 = getResources().getString(R.string.texto3);
        Generalidades p3 =  new Generalidades();
        p3.setNombre("Volcán Cerro Bravo");
        p3.setDescripcion(textop3);
        p3.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/VolcanCerroBravo/PublishingImages/Paginas/generalidades/cerroBravo.png");



        data.add(p1);
        data.add(p2);
        data.add(p3);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
    }
}

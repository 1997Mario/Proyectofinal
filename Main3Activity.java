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

        String textop4 = getResources().getString(R.string.texto4);
        Generalidades p4 =  new Generalidades();
        p4.setNombre("Volcán Cerro Machín");
        p4.setDescripcion(textop4);
        p4.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/VolcanCerroMachin/PublishingImages/Paginas/Generalidades/cerroMachin.png");

        String textop5 = getResources().getString(R.string.texto5);
        Generalidades p5 =  new Generalidades();
        p5.setNombre("Volcán Cerro Negro");
        p5.setDescripcion(textop5);
        p5.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/VolcanChiles/PublishingImages/Paginas/generalidades/VChiles2008-09-24_08_46_26.jpg");

        String textop6 = getResources().getString(R.string.texto6);
        Generalidades p6 =  new Generalidades();
        p6.setNombre("Volcán Chiles");
        p6.setDescripcion(textop6);
        p6.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/VolcanChiles/PublishingImages/Paginas/generalidades/chiles.png");

        String textop7 = getResources().getString(R.string.texto7);
        Generalidades p7 =  new Generalidades();
        p7.setNombre("volcán Cumbal");
        p7.setDescripcion(textop7);
        p7.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/VolcanCumbal/PublishingImages/Paginas/generalidades/22_CUMBAL%202007.JPG");

        String textop8 = getResources().getString(R.string.texto8);
        Generalidades p8 =  new Generalidades();
        p8.setNombre("Volcán Doña Juana");
        p8.setDescripcion(textop8);
        p8.setUrlImagen("https://www2.sgc.gov.co/sgc/volcanes/ComplejoVolcanicoDonaJuana/PublishingImages/Paginas/generalidades/27_DO%C3%91A%20JUANA%202008.jpg");

        String textop9 = getResources().getString(R.string.texto9);
        Generalidades p9 =  new Generalidades();
        p9.setNombre(" Volcán las Ánimas ");
        p9.setDescripcion(textop9);
        p9.setUrlImagen("https://www2.sgc.gov.co/Style%20Library/themes/Intranet/images/volcanes/VAnimasG.jpg");


        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);
        data.add(p5);
        data.add(p6);
        data.add(p7);
        data.add(p8);
        data.add(p9);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
    }
}

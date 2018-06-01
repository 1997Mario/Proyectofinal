package com.example.mariomarcillo.proyecto.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mariomarcillo.proyecto.R;
import com.example.mariomarcillo.proyecto.proyectoapi.IntApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {


    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaAdaptador listaDigitalAdapter;
    private boolean aptoParaCargar;
    public static final String TAG = "OBSERVATORIOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaDigitalAdapter = new ListaAdaptador(this);
        recyclerView.setAdapter(listaDigitalAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerDatos();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;
        obtenerDatos();
    }


    private void obtenerDatos() {

         IntApiService service = retrofit.create(IntApiService.class);
        Call<ArrayList<Observatorio>> RespuestaCall=service.obtenerLista();

        RespuestaCall.enqueue(new Callback<ArrayList<Observatorio>>() {
            public static final String TAG = "OBSERVATORIOS";

            @Override
            public void onResponse(Call<ArrayList<Observatorio>> call, Response<ArrayList<Observatorio>> response) {
                aptoParaCargar = true;
                if(response.isSuccessful())
                {
                    ArrayList<Observatorio> lista = response.body();
                    listaDigitalAdapter.adicionarLista(lista);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Observatorio>> call, Throwable t) {

                Log.e(TAG," onFailure: "+t.getMessage() );
            }
        });
    }

}

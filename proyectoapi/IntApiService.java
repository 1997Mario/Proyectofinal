package com.example.mariomarcillo.proyecto.proyectoapi;

import com.example.mariomarcillo.proyecto.models.Observatorio;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IntApiService {

    @GET("efg9-8jrp.json")
    Call<ArrayList<Observatorio>> obtenerLista();
}

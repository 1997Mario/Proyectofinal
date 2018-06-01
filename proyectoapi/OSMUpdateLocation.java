package com.example.mariomarcillo.proyecto.proyectoapi;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.example.mariomarcillo.proyecto.Mapa;

public class OSMUpdateLocation implements LocationListener {
    private Mapa actividad;

    public OSMUpdateLocation(Mapa actividad) {
        this.actividad = actividad;
    }

    public void onLocationChanged(Location location) {
        actividad.actualizaPosicionActual(location);
    }


    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}

package com.example.mariomarcillo.proyecto.models;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mariomarcillo.proyecto.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Generalidades  extends BaseAdapter {
    Activity activity;
    List<Generalidades> data;

    public Adapter_Generalidades (Activity activity, List<Generalidades> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if (v== null)
        {
            v=View.inflate(activity, R.layout.template_volcanes, null);
        }
        Generalidades p= data.get(position);
        TextView titulo=(TextView) v.findViewById(R.id.titulo);
        TextView descripcion=(TextView) v.findViewById(R.id.descripcion);
        ImageView img=(ImageView) v.findViewById(R.id.img);


        titulo.setText(p.getNombre());
        descripcion.setText(p.getDescripcion());


        Uri uri= Uri.parse(p.getUrlImagen());
        Picasso.with(activity).load(uri).into(img);

        return v;
    }
}

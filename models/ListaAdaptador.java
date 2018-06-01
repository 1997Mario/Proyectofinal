package com.example.mariomarcillo.proyecto.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mariomarcillo.proyecto.R;

import java.util.ArrayList;

public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.ViewHolder>
{
    private ArrayList<Observatorio> dataset;
    private Context context;

    public ListaAdaptador(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Observatorio p = dataset.get(position);


        holder.altitud.setText(p.getAltitud());
        holder.fecha_Instalacion.setText(p.getFechaDeInstalaciN());
        holder.id.setText(p.getId());
        holder.latitud.setText(p.getLatitud());
        holder.longitud.setText(p.getLongitud());
        holder.nombre.setText(p.getNombre());
        holder.ovs.setText(p.getOvs());
        holder.tipo_estacion.setText(p.getTipoDeEstaciN());
        holder.volcan.setText(p.getVolcN());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarLista(ArrayList<Observatorio> lista) {
        dataset.addAll(lista);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        private TextView altitud;
        private TextView fecha_Instalacion;
        private TextView id;
        private TextView latitud;
        private TextView longitud;
        private TextView nombre;
        private TextView ovs;
        private TextView tipo_estacion;
        private TextView volcan;

        public ViewHolder(View itemView)
        {
            super(itemView);
            altitud = (TextView) itemView.findViewById(R.id.altitud1);
            fecha_Instalacion= (TextView) itemView.findViewById(R.id.fecha1);
            id= (TextView) itemView.findViewById(R.id.id1);
            latitud= (TextView) itemView.findViewById(R.id.latitud1);
            longitud= (TextView) itemView.findViewById(R.id.longitu1);
            nombre= (TextView) itemView.findViewById(R.id.nombre1);
            ovs= (TextView) itemView.findViewById(R.id.ovs1);
            tipo_estacion= (TextView) itemView.findViewById(R.id.tipo1);
            volcan= (TextView) itemView.findViewById(R.id.volcan1);
        }
    }

}

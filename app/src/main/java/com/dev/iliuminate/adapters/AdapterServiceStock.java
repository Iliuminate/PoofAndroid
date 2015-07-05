package com.dev.iliuminate.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.iliuminate.poofandroid.R;
import com.dev.iliuminate.structures.Stock;

import java.util.ArrayList;

/**
 * Created by Iliuminate on 05/07/2015.
 */
public class AdapterServiceStock extends BaseAdapter {

    private Activity actividad;
    private ArrayList<?> lista;
    LayoutInflater inflater;


    public AdapterServiceStock(Activity actividad, ArrayList<?> lista) {
        this.actividad = actividad;
        this.lista = lista;

        inflater = (LayoutInflater)actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int index) {
        return lista.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Declaramos todos los objetos View que usaremos para el respectivo adapter
        View viewObj=view;

        viewObj = inflater.inflate(R.layout.adapter_5c, viewGroup,false);


        TextView a, b;
        ImageView imgSerciesStock;

        a=(TextView)viewObj.findViewById(R.id.txs1);
        b=(TextView)viewObj.findViewById(R.id.txs2);
        imgSerciesStock=(ImageView)viewObj.findViewById(R.id.imgServicesStock);


       // String itemName=(Stock)lista.get(i);


        a.setText();
        b.setText("2");

        imgSerciesStock.setImageResource(R.drawable.ic_launcher);

        return viewObj;
    }


}

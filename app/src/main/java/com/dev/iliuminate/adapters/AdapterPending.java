package com.dev.iliuminate.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dev.iliuminate.poofandroid.R;
import com.dev.iliuminate.structures.Pending;

import java.util.ArrayList;

/**
 * Created by Iliuminate on 04/07/2015.
 */
public class AdapterPending extends BaseAdapter {


    private  Activity actividad;
    private  ArrayList<?> lista;
    LayoutInflater inflater;


    public AdapterPending(Activity actividad, ArrayList<?> lista) {
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        //Declaramos todos los objetos View que usaremos para el respectivo adapter
        View viewObj=view;

        viewObj = inflater.inflate(R.layout.adapter_5a, viewGroup,false);


        TextView a, b, c, d, e;

        a=(TextView)viewObj.findViewById(R.id.tx1);
        b=(TextView)viewObj.findViewById(R.id.tx2);
        c=(TextView)viewObj.findViewById(R.id.tx3);
        d=(TextView)viewObj.findViewById(R.id.tx4);
        e=(TextView)viewObj.findViewById(R.id.tx5);


        String item=((Pending) lista.get(position)).getItem()+"";
        String value=((Pending) lista.get(position)).getValue()+"";
        String userName=((Pending) lista.get(position)).getUser_name().toString()+"";
        String phone=((Pending) lista.get(position)).getPhone()+"";
        String direction=((Pending) lista.get(position)).getDirection().toString()+"";
        String total=((Pending) lista.get(position)).getTotal()+"";


        try {
            a.setText("Item: "+item+"      Value: $"+value);
            b.setText(total);
            c.setText(userName);
            d.setText(phone);
            e.setText(direction);
        } catch (Exception e1) {
            Log.e("PendingAdapter", e + "");
        }


        return viewObj;
    }
}

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
import com.dev.iliuminate.structures.Done;

import java.util.ArrayList;

/**
 * Created by Iliuminate on 04/07/2015.
 */
public class AdapterDone extends BaseAdapter {

    private Activity actividad;
    private ArrayList<?> lista;
    LayoutInflater inflater;


    public AdapterDone(Activity actividad, ArrayList<?> lista) {
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

        viewObj = inflater.inflate(R.layout.adapter_5b, viewGroup,false);


        TextView a, b, c, d, e;

        a=(TextView)viewObj.findViewById(R.id.txd1);
        b=(TextView)viewObj.findViewById(R.id.txd2);
        c=(TextView)viewObj.findViewById(R.id.txd3);
        d=(TextView)viewObj.findViewById(R.id.txd4);
        e=(TextView)viewObj.findViewById(R.id.txd5);

        String item=((Done) lista.get(position)).getItem()+"";
        String value=((Done) lista.get(position)).getValue()+"";
        String userName=((Done) lista.get(position)).getUser_name().toString()+"";
        String phone=((Done) lista.get(position)).getPhone()+"";
        String direction=((Done) lista.get(position)).getDirection().toString()+"";
        String total=((Done) lista.get(position)).getTotal()+"";


        try {
            a.setText("Item: "+item+"      Value: $"+value);
            b.setText(total);
            c.setText(userName);
            d.setText(phone);
            e.setText(direction);
        } catch (Exception e1) {
            Log.e("Done", e + "");
        }

        return viewObj;
    }
}

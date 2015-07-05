package com.dev.iliuminate.poofandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;

import com.dev.iliuminate.adapters.AdapterPending;
import com.dev.iliuminate.adapters.AdapterDone;
import com.dev.iliuminate.adapters.AdapterServiceStock;
import com.dev.iliuminate.structures.Pending;
import com.dev.iliuminate.structures.Done;

import java.util.ArrayList;


public class Main extends Activity {

    TabHost tabhost;
    ListView listPending, listDone, listStock;

    ArrayList<Pending> strOrders;
    ArrayList<Done> strStocks;
    AdapterPending adapterPending;
    AdapterDone adapterDone;
    AdapterServiceStock adapterStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_main);


        tabhost=(TabHost)findViewById(R.id.tabHost);
        tabhost.setup();

        listPending =(ListView)findViewById(R.id.listPending);
        listDone =(ListView)findViewById(R.id.listDone);
        listStock =(ListView)findViewById(R.id.listServices);


        TabHost.TabSpec tabSpec=tabhost.newTabSpec("pending");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Pending");
        tabhost.addTab(tabSpec);

        tabSpec=tabhost.newTabSpec("done");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Done");
        tabhost.addTab(tabSpec);

        tabSpec=tabhost.newTabSpec("service_stock");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Service Stock");
        tabhost.addTab(tabSpec);

        Pending order=new Pending();
        ArrayList<Pending> aux=new ArrayList<Pending>();
        aux.add(order);

       /* //Cargamos la lista en la pantalla PENDING
        try {
            adapterPending = new AdapterPending (Main.this, aux);
            listPending.setAdapter(adapterPending);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }*/

       /* //Cargamos la lista en la pantalla DONE
        try {
            adapterDone = new AdapterDone (Main.this, aux);
            listDone.setAdapter(adapterDone);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }*/

        //Cargamos la lista en la pantalla STOCK
        try {
            adapterStock = new AdapterServiceStock(Main.this, aux);
            listStock.setAdapter(adapterStock);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

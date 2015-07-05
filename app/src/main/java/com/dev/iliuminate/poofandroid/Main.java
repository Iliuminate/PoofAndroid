package com.dev.iliuminate.poofandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.dev.iliuminate.adapters.AdapterPending;
import com.dev.iliuminate.adapters.AdapterDone;
import com.dev.iliuminate.adapters.AdapterServiceStock;
import com.dev.iliuminate.structures.Pending;
import com.dev.iliuminate.structures.Done;
import com.dev.iliuminate.structures.Stock;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


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

        ArrayList<Pending> aux=new ArrayList<Pending>();
        ArrayList<Done> aux2=new ArrayList<Done>();
        ArrayList<Stock> aux3=new ArrayList<Stock>();



        //Instanciamos un ejemplo de cada estructura
        Pending peding;
        Done done;
        Stock stock;

        consultarTiendas(getIntent().getStringExtra("SOTER_IDE"));
        Log.e("Tiendas","Item: "+getIntent().getStringExtra("SOTER_IDE"));
       /* for (int i=0; i<=10;i++) {
            peding=new Pending();
            peding.setUser_name("Carlos"+i);
            peding.setValue(1614+i);
            peding.setDirection("Call 10");
            peding.setItem(i);
            peding.setPhone(31676+i);
            peding.setTotal(6789000+i);
            aux.add(peding);

            done=new Done();
            done.setUser_name("Carlos"+i);
            done.setValue(1614+i);
            done.setDirection("Call 10");
            done.setItem(i);
            done.setPhone(31676+i);
            done.setTotal(6789000+i);
            aux2.add(done);

            stock =new Stock();
            stock.setItemName("item "+i);
            stock.setValue(10+i);
            aux3.add(stock);
        }*/


        /*//Cargamos la lista en la pantalla PENDING
        try {
            adapterPending = new AdapterPending (Main.this, aux);
            listPending.setAdapter(adapterPending);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }

        //Cargamos la lista en la pantalla DONE
        try {
            adapterDone = new AdapterDone (Main.this, aux2);
            listDone.setAdapter(adapterDone);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }

        //Cargamos la lista en la pantalla STOCK
        try {
            adapterStock = new AdapterServiceStock(Main.this, aux3);
            listStock.setAdapter(adapterStock);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }*/

    }



    public void consultarTiendas (String tienda_id)
    {

        final String endpoint = "http://192.168.0.101:8080/PoofAPI/v1/item/storeInventory/"+tienda_id;
        AsyncHttpClient client = new AsyncHttpClient();


        client.get(endpoint, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("Tiendas","Error consultando tiendas: "+statusCode+" - "+responseString);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson=new Gson();

                //List<Item> items = gson.fromJson(responseString, Class<List<Item>>);

                Type listType = new TypeToken<ArrayList<Item>>() {
                }.getType();
                ArrayList<Item> items = new Gson().fromJson(responseString, listType);

                Toast.makeText(Main.this, "Tamaño: "+items.size(), Toast.LENGTH_LONG).show();
                Log.e("Tiendas","Tamaño: "+items.size());

                load_items(items);

            }
        });

    }



    private void load_items(ArrayList<Item> lista)
    {
        List<String> aux=new ArrayList<String>();
        for(Item item:lista)
        {
            aux.add("Item:          "+item.getName()+
                    "\nValue:        "+item.getPrice()+
                    "\nCategory: "+item.getCategory()
            );

        }

        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main.this,
                    android.R.layout.simple_list_item_1, aux);
            listStock.setAdapter(adapter);
        } catch (Exception e) {
            Log.e("Adapter",e+"");
        }

    }

    private void load_pending(ArrayList<Pending> aux)
    {
        try {
            adapterPending = new AdapterPending (Main.this, aux);
            listPending.setAdapter(adapterPending);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }
    }

    private void load_done(ArrayList<Done> aux2)
    {
        try {
            adapterDone = new AdapterDone (Main.this, aux2);
            listDone.setAdapter(adapterDone);
        } catch (Exception e) {
            Log.e("TOUCH LIST", "Error inicializando la lista> " + e.toString());
        }
    }

    private void load_stock(ArrayList<Stock> aux3)
    {
        try {
            adapterStock = new AdapterServiceStock(Main.this, aux3);
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

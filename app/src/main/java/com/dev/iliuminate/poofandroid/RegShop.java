package com.dev.iliuminate.poofandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.dev.iliuminate.structures.Store;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class RegShop extends Activity {

    EditText edtName, edtMail, edtPass1, edtPass2, edtCategory, edtPhone;
    Spinner spRazon;
    ImageView btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_reg_shop);


        edtName=(EditText)findViewById(R.id.edtRegShopName);
        edtCategory=(EditText)findViewById(R.id.edtRegShopNUIP);
        edtMail=(EditText)findViewById(R.id.edtRegShopMail);
        edtPass1=(EditText)findViewById(R.id.edtRegShopPass1);
        edtPass2=(EditText)findViewById(R.id.edtRegShopPass2);
        edtPhone=(EditText)findViewById(R.id.edtPhone);

        spRazon=(Spinner)findViewById(R.id.spinnerShop);
        btnRegister=(ImageView)findViewById(R.id.btnRegShopImg);


        //Llenamos el spinner
        List<String> list = new ArrayList<String>();
        list.add("Good");
        list.add("Service");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRazon.setAdapter(dataAdapter);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(RegShop.this, "Pulsando Registro", Toast.LENGTH_SHORT).show();
                Store store=new Store();
                store.setIdstore(1);
                store.setName(edtName.getText().toString()+"");
                store.setPhone(edtPhone.getText()+"");
                store.setCategory(edtCategory.getText().toString()+"");
                store.setType(spRazon.getSelectedItem().toString()+"");
                store.setAddress("0");
                store.setEmail(edtMail.getText().toString()+"");
                store.setLatitude("0");
                store.setLongitude("0");

                createStore(store);
            }
        });


    }


    public void createStore (Store store)
    {

        final String endpoint = "http://192.168.0.101:8080/PoofAPI/v1/store";
        AsyncHttpClient client = new AsyncHttpClient();
        Gson gson = new Gson();
        String jsonString = gson.toJson(store);
        StringEntity jsonStringEntity = null;
        try {
            jsonStringEntity =
                    new StringEntity(jsonString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Log.e("StringEntity", "Error de StringEntity: " + e);
        }
        jsonStringEntity.setContentType("application/json");


        client.post(this,
                endpoint,
                jsonStringEntity,
                "application/json",

                new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Toast.makeText(RegShop.this,"tienda creada con exito", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(RegShop.this,"No se pudo agregar la tienda", Toast.LENGTH_LONG).show();
                        Log.e("Fail Insert Shop", "No se pudo agregar la tienda, "+statusCode+ " - "+error.getMessage());
                    }
                }

                );
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reg_shop, menu);
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

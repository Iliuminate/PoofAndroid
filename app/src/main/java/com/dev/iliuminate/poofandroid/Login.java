package com.dev.iliuminate.poofandroid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dev.iliuminate.poofandroid.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

public class Login extends Activity {


    EditText edtName, edtPass;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);


        edtName=(EditText)findViewById(R.id.edtName);
        edtPass=(EditText)findViewById(R.id.edtPass);
        btnLogin=(Button)findViewById(R.id.btnLoginImg);
        btnRegister=(Button)findViewById(R.id.btnRegisterImg);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWS(edtName.getText().toString());
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*Por cambios en la idea, se suprime la opcion para empresar*/
               register_options();
            }
        });


    }


    /**
     * Lanzamos el cuadro de opción para los registros
     */
    private void register_options()
    {
        final Dialog dialogo=new Dialog(this);
        dialogo.setContentView(R.layout.diag_opcion_register);
        dialogo.setTitle("Select ");
        dialogo.setCancelable(true);

        ImageView regClient=(ImageView)dialogo.findViewById(R.id.btnRegClient);
        ImageView regShop=(ImageView)dialogo.findViewById(R.id.btnRegShop);

        regClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerClient();
            }
        });

        regShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerShop();
            }
        });

        dialogo.show();
    }


    public void loginWS (String phone)
    {

        final String endpoint = "http://192.168.0.101:8080/PoofAPI/v1/store/login/"+phone;
        AsyncHttpClient client = new AsyncHttpClient();


        client.get(endpoint, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                int store_id = Integer.parseInt(responseString);

                if (store_id > -1)
                {
                    Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_LONG).show();
                    launch_main(store_id);
                }
                else
                {
                    Toast.makeText(Login.this, "Usuario no valido", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    private void registerClient()
    {
        Intent i=new Intent(this, RegClient.class);
        startActivity(i);
    }

    private void registerShop()
    {
        Intent i=new Intent(this, RegShop.class);
        startActivity(i);
    }

    private void launch_main(int store_id)
    {
        Intent i=new Intent(this, Main.class);
        i.putExtra("SOTER_IDE",store_id);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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

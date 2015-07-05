package com.dev.iliuminate.poofandroid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.dev.iliuminate.poofandroid.R;

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
                launch_main();
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

    private void launch_main()
    {
        Intent i=new Intent(this, Main.class);
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

package com.dev.iliuminate.poofandroid;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.dev.iliuminate.database.User;

import java.sql.Date;
import java.util.Calendar;

public class RegClient extends Activity {

    EditText edtUserName, edtName, edtLastName, edtPass1, edtPass2, edtBirthdate;
    RadioButton rdMale, rdFemale;
    ImageView btnRegister;
    String birthDate;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;

    boolean swBirthday=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_reg_client);

        btnRegister=(ImageView)findViewById(R.id.btnDone);

        edtUserName=(EditText)findViewById(R.id.edtUserName);
        edtName=(EditText)findViewById(R.id.edtName);
        edtLastName=(EditText)findViewById(R.id.edtLastName);
        edtPass1=(EditText)findViewById(R.id.edtPass1);
        edtPass2=(EditText)findViewById(R.id.edtPass2);
        edtBirthdate=(EditText)findViewById(R.id.edtBirthdate);

        rdMale=(RadioButton)findViewById(R.id.rdMale);
        rdFemale=(RadioButton)findViewById(R.id.rdFemale);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year-18, month+1, day);


        edtBirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(edtBirthdate);
            }
        });

        edtBirthdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                setDate(edtBirthdate);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });


    }



    private void addUser()
    {
        User user=new User();
        boolean user_add=true;
        user.setUserName(edtUserName.getText().toString());
        user.setName(edtName.getText().toString());
        user.setLastName(edtLastName.getText().toString());

        if(validar_vacios()) {

            if (edtPass1.getText().toString().equals(edtPass2.getText().toString()))
                user.setPasseord(edtPass1.getText().toString());
            else
                user_add = false;

            try {
                //user.setBirthdate(Date.valueOf(edtBirthdate.getText().toString()));
               // user.setBirthdate(Date.parse("2015/05/02"));
            } catch (Exception e) {
                Log.i("No insert User", e + "");
                user_add = false;
            } finally {
            }

            if (user_add)
                user.save();
        }
        else
        {
            Toast.makeText(this, "Validar Campos", Toast.LENGTH_SHORT).show();
        }
    }

    String a,b,c,d,e,f,g;
    private boolean validar_vacios()
    {
        boolean sw=true;
        a=edtUserName.getText().toString().trim();
        b=edtName.getText().toString().trim();
        c=edtLastName.getText().toString().trim();
        d=edtPass1.getText().toString().trim();
        e=edtPass2.getText().toString().trim();
        f=edtBirthdate.getText().toString().trim();

        sw=(rdMale.isChecked()||rdFemale.isChecked())?true:false;

        sw=(a.equals("")&&b.equals("")&&c.equals("")&&d.equals("")&&e.equals("")&&f.equals(""))?false:true;

        return sw;
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        /*Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();*/
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        /*dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));*/
        edtBirthdate.setText(year+"/"+month+"/"+day);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reg_customer, menu);
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

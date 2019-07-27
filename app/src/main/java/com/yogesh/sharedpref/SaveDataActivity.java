package com.yogesh.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SaveDataActivity extends AppCompatActivity {

    TextView fname, lname, email, mobilenumber;
    SharedPreferences sharedpreferences;
    String f_name,l_name,phone_num,e_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_data);

        fname=(TextView)findViewById(R.id.txtFirstName);
        lname=(TextView)findViewById(R.id.txtLastName);
        email=(TextView)findViewById(R.id.txtEmail);
        mobilenumber=(TextView)findViewById(R.id.txtMno);

        sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);

        f_name=sharedpreferences.getString(MainActivity.FName,"");
        l_name=sharedpreferences.getString(MainActivity.LName,"");
        phone_num=sharedpreferences.getString(MainActivity.Phone,"");
        e_mail=sharedpreferences.getString(MainActivity.Email,"");

        fname.setText(f_name);
        lname.setText(l_name);
        email.setText(e_mail);
        mobilenumber.setText(phone_num);
    }
}

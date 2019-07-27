package com.yogesh.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fname,lname,email,mobilenumber;
    Button saveproceed,next;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String FName = "fnameKey";
    public static final String LName = "lnameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname=(EditText)findViewById(R.id.firstName);
        lname=(EditText)findViewById(R.id.lastName);
        email=(EditText)findViewById(R.id.email);
        mobilenumber=(EditText)findViewById(R.id.Mnumber);
        saveproceed=(Button)findViewById(R.id.btnSave);
        next=(Button)findViewById(R.id.btnNext);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        saveproceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedpreferences.edit();

                String fullname=fname.getText().toString();
                String lastname=lname.getText().toString();
                String phone=mobilenumber.getText().toString();
                String emailvalue=email.getText().toString();

                if(fullname.isEmpty()){
                    fname.setError("Enter the full name");
                    fname.setText("");
                }
                else if (lastname.isEmpty()){
                    lname.setError("Enter the last name");
                    lname.setText("");
                }
                else if (phone.isEmpty()){
                    mobilenumber.setError("Enter the mobile number");
                    mobilenumber.setText("");
                }
                else if (emailvalue.isEmpty()){
                    email.setError("Enter the email id ");
                    email.setText("");
                }
                else if (fullname.isEmpty()||lastname.isEmpty()){
                    fname.setError("Enter the full name");
                    lname.setError("Enter the last name");
                    fname.setText("");
                    lname.setText("");
                }
                else if (lastname.isEmpty()||phone.isEmpty()){
                    fname.setError("Enter the last name");
                    mobilenumber.setError("Enter the phone number");
                    fname.setText("");
                    mobilenumber.setText("");
                }
                else if (phone.isEmpty()||emailvalue.isEmpty()){
                    fname.setError("Enter the phone number");
                    email.setError("Enter the email id ");
                    fname.setText("");
                    email.setText(""); }
                else {
                    editor.putString(FName, fullname);
                    editor.putString(LName, lastname);
                    editor.putString(Phone, phone);
                    editor.putString(Email, emailvalue);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_LONG).show();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SaveDataActivity.class));
            }
        });










    }
}

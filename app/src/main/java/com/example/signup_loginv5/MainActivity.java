package com.example.signup_loginv5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    public final static String CIN="cin";
    public final static String PASSWORD="password";

    Button change_language;
    Button change_password;
    Button Login;
    Button Register_btn;
    EditText cin;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        // change action bar title
        //  NoAction bar was elected so this code will not be compile
        /* ActionBar actionBar = getSupportActionBar();
         actionBar.setTitle(getResources().getString(R.string.app_name));*/


        change_language = findViewById(R.id.langue_btn);
        change_password = findViewById(R.id.forget_password);
        cin = findViewById(R.id.cin_login);
        password = findViewById(R.id.editTextNumberPassword);
        Login = findViewById(R.id.login);
        Register_btn = findViewById(R.id.registre_btn);

        change_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showChangeLanguageDialog();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),ValidateUser.class);
                intent.putExtra(CIN, cin.getText().toString());
                intent.putExtra(PASSWORD, password.getText().toString());
                startActivity(intent);
            }
        });

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Reset_password.class);
                startActivity(intent);
            }
        });

        Register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Register_Form.class);
                startActivity(intent);
            }
        });
    }




    private void showChangeLanguageDialog() {
        final String[] listItems = {"Francais","English","عربية"};
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle(R.string.selectLanguage);
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    if(which== 0){
                        // french
                        setLocale("fr");
                        recreate();
                        dialog.cancel();

                    }
                else if(which== 1){
                    // french
                    setLocale("en");
                    recreate();
                    dialog.cancel();
                }
                else if(which== 2){
                    // french
                    setLocale("ar");
                    recreate();
                    dialog.cancel();
                }

            }

        });
        AlertDialog mdialog = mBuilder.create();
        mdialog.show();

    }
    private void setLocale(String locale){
      Locale loca = new Locale(locale);
      Locale.setDefault(loca);
        Configuration configuration = new Configuration();
        configuration.locale = loca;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
       // save data to shared
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang", locale);
        editor.apply();
    }

    // load language saved in shared preferences

   public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings",MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }
}
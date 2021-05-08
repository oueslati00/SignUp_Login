package com.example.signup_loginv5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.signup_loginv5.ValidCase.User;
import com.example.signup_loginv5.ValidCase.ValidationXml;

public class Register_Form extends AppCompatActivity {

    public String Registration_error;
    public static final String USERNAME ="USERNAME";
    public static final String CIN ="cin";
    public static final String EMAIL ="EMAIL";
    public static final String  PHONE_NUMBER="PHONE_NUMBER";

    EditText username,password,confirm_password,cin,phone_number,email;
    Button valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__form);
        setId();
        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              boolean testusername=  ValidationXml.validationUserNameXml(username);
                boolean testpassword = ValidationXml.validatePasswordXml(password);
                boolean testConfirmationPassword = ValidationXml.validateConfirmationPassword(password,confirm_password);
                boolean testcin = ValidationXml.validateCin(cin);
                boolean testphonenumber = ValidationXml.ValidatePhoneNumber(phone_number);
                boolean testemail = ValidationXml.ValidateEmail(email);
                if(testcin && testConfirmationPassword && testemail && testpassword && testphonenumber && testusername){
                      User user= User.createObject(findViewById(android.R.id.content).getRootView());

                    boolean validate_user = createUserInDAtaBase(user);
                    if(!validate_user){
                        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Register_Form.this);
                        mBuilder.setTitle(R.string.error_message);
                    }else{
                        user.deletePassword();
                        User second_user = user.getUserWithoutPassword();
                        Intent intent =new Intent(getApplicationContext(),Acceuil.class);
                        startActivity(intent);

                    }

                }
            }
        });

    }

    private boolean createUserInDAtaBase(User user) {
        // here we will create a user in data base
        // test information like cin or email if was already exist
        // validation with boolean return value
        // set registration_error value with current error message
        return true;
    }

    public void setId(){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password_registre);
        confirm_password = findViewById(R.id.confirm_password_registre);
        cin = findViewById(R.id.cin_registre);
        phone_number = findViewById(R.id.phone_number_registre);
        email = findViewById(R.id.email_registre);
        valid = findViewById(R.id.valide_registre);
    }
}
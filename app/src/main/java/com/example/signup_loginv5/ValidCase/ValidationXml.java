package com.example.signup_loginv5.ValidCase;

import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;


public class ValidationXml {

    public static boolean validationUserNameXml(EditText username){
        if (username.getText().toString().trim().isEmpty()) {
            username.setError("Please fill out this field");
            return false;
        }
        return true;

    }

    public static boolean validatePasswordXml(EditText password, TextInputLayout txtInLayoutRegPassword){
        if (password.getText().toString().trim().isEmpty()) {
            txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
            password.setError("Please fill out this field");
            return false;
        } else {

            if(!Validation.PasswordValidation(password.getText().toString().trim())){

                txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                password.setError("is not a valid password");
                return false;
            }
            else{
                txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
            }

        }
        return true;

    }
    public static boolean validatePasswordXml(EditText password){
        if (password.getText().toString().trim().isEmpty()) {
            password.setError("Please fill out this field");
            return false;
        } else {

            if(!Validation.PasswordValidation(password.getText().toString().trim())){

                password.setError("is not a valid password");
                return false;
            }
            else{

            }

        }
        return true;

    }


    public static boolean validateConfirmationPassword(EditText password, EditText confirmationPassword , TextInputLayout txtInLayoutRegPassword){

        if (confirmationPassword.getText().toString().trim().isEmpty()) {
            txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
            confirmationPassword.setError("Please fill out this field");
            return false;
        } else {
            if(!Validation.PasswordConfirmationValidation(password.getText().toString().trim(), confirmationPassword.getText().toString().trim())){
                txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                confirmationPassword.setError("is not the same");
                return false;
            }

        }
        return true;
    }
    public static boolean validateConfirmationPassword(EditText password, EditText confirmationPassword ){

        if (confirmationPassword.getText().toString().trim().isEmpty()) {

            confirmationPassword.setError("Please fill out this field");
            return false;
        } else {
            if(!Validation.PasswordConfirmationValidation(password.getText().toString().trim(), confirmationPassword.getText().toString().trim())){
                confirmationPassword.setError("is not the same");
                return false;
            }

        }
        return true;
    }
    public static boolean validateCin(EditText cin){
        if(cin.getText().toString().trim().isEmpty()){
            cin.setError("Please fill out this filed");
            return false;
        }
        else {
            if(!Validation.cinValidation(cin.getText().toString())){
                cin.setError("not valid ");
                return  false;
            }

        }
        return true;
    }
    public static boolean ValidatePhoneNumber(EditText phonenumber){
        if(phonenumber.getText().toString().trim().isEmpty()){
            phonenumber.setError("Please fill out this filed");
            return false;
        }
        else{
            if(!Validation.phoneNumberValidation(phonenumber.getText().toString().trim()))
            {
                phonenumber.setError("not valid");
                return false;
            }

        }
          return true;
    }

    public static boolean ValidateEmail(EditText email){
        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Please fill out this field");
            return false;
        }
        else{
            if(!Validation.validationMail(email.getText().toString().trim())){
                email.setError("not a valid mail");
                return false;
            }
        }
        return true;
    }
}

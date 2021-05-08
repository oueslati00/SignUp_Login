package com.example.signup_loginv5.ValidCase;

import android.view.View;
import android.widget.EditText;

import com.example.signup_loginv5.R;

public class User {

    private String UserName;
    private String password;
    private String cin;
    private String phoneNumber;
    private String email;

    private  User(String userName, String password, String cin, String phoneNumber, String email) {
        UserName = userName;
        this.password = password;
        this.cin = cin;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    private  User(){
    }
    public static User createObject(View v){
        String userName = ((EditText)v.findViewById(R.id.username)).getText().toString();

        String password = ((EditText)v.findViewById(R.id.password_registre)).getText().toString();

        String phoneNumber = ((EditText)v.findViewById(R.id.phone_number_registre)).getText().toString();

        String cin = ((EditText)v.findViewById(R.id.cin_registre)).getText().toString();

        String email =((EditText)v.findViewById(R.id.email_registre)).getText().toString();

        User user = new User(userName,password,cin,phoneNumber,email);
        return user;
    }


    public void deletePassword(){
        this.password=null;

    }
    public User getUserWithoutPassword(){
        User user = new User();
        user.cin=this.cin;
        user.UserName = this.UserName;
        user.cin = this.cin;
        user.phoneNumber = this.phoneNumber;
        user.email = this.email;
        return user;
    }
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "userName " + this.UserName +
                " password " + this.password +
                " cin " + this.cin +
                " phone number" + this.phoneNumber +
                " email " + this.email;
    }
}
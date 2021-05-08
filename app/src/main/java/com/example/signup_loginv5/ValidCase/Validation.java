package com.example.signup_loginv5.ValidCase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {


    public static boolean validationMail(String email){
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
   public static boolean phoneNumberValidation(String phoneNumber){
           String regex= "^[0-9]{8}$";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(phoneNumber);
       return matcher.matches();
    }
    public static boolean cinValidation(String cin){
        String regex= "^[0-9]{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cin);
        return matcher.matches();
    }
    /*
    ^                                   # start of line
  (?=.*[0-9])                       # positive lookahead, digit [0-9]
  (?=.*[a-z])                       # positive lookahead, one lowercase character [a-z]
  (?=.*[A-Z])                       # positive lookahead, one uppercase character [A-Z]
  (?=.*[!@#&()–[{}]:;',?/*~$^+=<>]) # positive lookahead, one of the special character in this [..]
  .                                 # matches anything
  {8,20}                            # length at least 8 characters and maximum of 20 characters
$                                   # end of line
    * */
    public static boolean PasswordValidation(String password){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    static boolean PasswordConfirmationValidation(String password1, String password2 ){
        return password1.equals(password2);
    }
}

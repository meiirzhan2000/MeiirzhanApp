package com.example.meiirzhanapp;

import android.content.Context;
import android.provider.ContactsContract;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class user {
    private String firstName;
    private String secondName;
    private String password;
    private String confirmPassword;

    public String getSecondName() {
        return secondName.replaceAll("\\s", "");
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getEmail() {
        return email.replaceAll("\\s", "");
    }

    public String getPhone() {
        return phone.replaceAll("\\s", "");
    }

    public String getFirstName() {
        return firstName.replaceAll("\\s", "");
    }
    private String email;
    private String phone;

    public user(String firstName, String secondName, String password, String email, String confirmPassword){
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    protected String spaceDelete(String value){
        return value.replaceAll("\\s", "");
    }

    public user(Context context, String emailPhone, String password, Boolean which){
        if(which) this.email = emailPhone; else this.phone = emailPhone;
        this.password = password;
    }

    public static String checkEmail(String email){
        final String format = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(format);
        Matcher m = p.matcher(email);
        if(email.length() < 4){
            return "The Email Is Too Short";
        }
        else if(!m.matches()) {
            return "The Format Of The Email Is Wrong";
        }
        return "";
    }

    public static String password(String password, String passwordConfirm){
        if(password.length() <= 8){
            return "The Password Is Too Short";
        }
        else if(!password.equals(passwordConfirm)){
            return "The Password Does Not Match";
        }
        return "";
    }

    public static String nameChecker(String name){
        if(name.length() < 1){
            return "Enter Name";
        }
        else if(!name.matches("[a-zA-Z]+")){
            return "Enter Only Alphabetic Characters";
        }
        return "";
    }

}

package com.example.meiirzhanapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

public class Register extends AppCompatActivity {
    private EditText firstName;
    private EditText secondName;
    private EditText password;
    private EditText confirmPassword;
    private EditText email;
    private Button register;
    private user u;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context = getApplicationContext();
        Button button = findViewById(R.id.returnBack);
        firstName = findViewById(R.id.firstName);
        secondName = findViewById(R.id.secondName);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u = new user(email.getText().toString(), firstName.getText().toString(),
                        password.getText().toString(), secondName.getText().toString());
                try {
                    fullChecker(u.getFirstName(), u.getSecondName(),
                            password.getText().toString(), confirmPassword.getText().toString(),
                            u.getEmail());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void fullChecker(String firstName, String secondName, String password, String confirmPassword, String email) throws SQLException {
        if(user.nameChecker(firstName).length() > 1) toastShow(user.nameChecker(firstName));
        else if(user.nameChecker(secondName).length() > 1) toastShow(user.nameChecker(secondName));
        else if(user.password(password, confirmPassword).length() > 1) toastShow(user.password(password, confirmPassword));
        else if(user.checkEmail(email).length() > 1) toastShow(user.checkEmail(email));
        else{
            Database d = new Database();
            if(d.connectionCl(u)){
                Toast.makeText(Register.this, "Successfully registered" ,Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(Register.this, "Error occurred, Try Again Latter" ,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void toastShow(String message){
        Toast.makeText(Register.this, message, Toast.LENGTH_LONG).show();
    }

}

/* startActivity(new Intent(Register.this, MainActivity.class)); */
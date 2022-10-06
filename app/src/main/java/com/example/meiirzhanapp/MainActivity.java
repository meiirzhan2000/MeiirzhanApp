package com.example.meiirzhanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checker(username.getText().toString(), "Username") && checker(password.getText().toString(), "Password")){
                    startActivity(new Intent(MainActivity.this, Register.class));
                }
            }
        });
    }

    public boolean checker(String name, String pasOrLog){
        if(name.length() <= 0){
            Toast.makeText(getApplicationContext(), "Enter "+pasOrLog, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
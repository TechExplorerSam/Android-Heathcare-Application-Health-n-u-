package com.example.healthandyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LOGIN_ACTIVITY extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btn;
    Button btn1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextText4);
        edPassword = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.button5);
        tv = findViewById(R.id.textView);
        btn1=findViewById(R.id.button6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "health n you", null, 1);

                if (Username.length() == 0 || password.length() == 0) {
                                           Toast.makeText(getApplicationContext(), "Please fill the Credentials only then you Will be Logged in", Toast.LENGTH_SHORT).show();
                                       } else {
                    if (db.login(Username, password) ==1) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", Username);
                        // to save our data with key and value.
                        editor.apply();
                        startActivity(new Intent(LOGIN_ACTIVITY.this, HOMEACTIVITY.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid username and password Check them and try again", Toast.LENGTH_SHORT).show();
                    }
                }




                               }
                               }
        );

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LOGIN_ACTIVITY.this, USER_REGISTRATION_ACTIVITY.class));
            }
        });
    }
}


package com.example.healthandyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class USER_REGISTRATION_ACTIVITY extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        edUsername = findViewById(R.id.editTextText4);
        edEmail = findViewById(R.id.editTextTextEmailAddress2); // Corrected ID
        edPassword = findViewById(R.id.editTextTextPassword);
        edConfirm = findViewById(R.id.editTextTextPassword2); // Corrected ID
        btn = findViewById(R.id.button6);
        tv = findViewById(R.id.tvDontHaveAccount);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(USER_REGISTRATION_ACTIVITY.this, LOGIN_ACTIVITY.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db=new Database(getApplicationContext(),"health n you",null,1);

                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details correctly", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirm)) { // Changed to use .equals() for string comparison
                        if (isValid(password)) {
                            Toast.makeText(getApplicationContext(), "Record inserted successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(USER_REGISTRATION_ACTIVITY.this, LOGIN_ACTIVITY.class));
                            db.register(username, email, password);
                        } else {
                            Toast.makeText(getApplicationContext(), "Password does not meet the requirements", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and confirm passwords did not match, check them again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String passwordHere) {
        int f1 = 0, f2 = 0, f3 = 0;

        if (passwordHere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordHere.length(); p++) {
                if (Character.isLetter(passwordHere.charAt(p))) {
                    f1 = 1;
                }
            }

            for (int r = 0; r < passwordHere.length(); r++) {
                if (Character.isDigit(passwordHere.charAt(r))) {
                    f2 = 1;
                }
            }

            for (int s = 0; s < passwordHere.length(); s++) {
                char c = passwordHere.charAt(s);
                if ((c >= 33 && c <= 46) || c == 64) { // Corrected the range for special characters
                    f3 = 1;
                }
            }

            return f1 == 1 && f2 == 1 && f3 == 1;
        }
    }
}

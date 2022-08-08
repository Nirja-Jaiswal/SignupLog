package com.example.signuplog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button logiin;
    TextView register;
    boolean isEmailValid, isPasswordValid;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        logiin = findViewById(R.id.logiin);
        register = findViewById(R.id.register);


        logiin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equalsIgnoreCase("")) {
                    email.setError("email cant be empty");
                } else if (email.getText().toString().matches(emailPattern)) {
                    email.setError(getResources().getString(R.string.error_invalid_email));
                } else if (password.getText().toString().isEmpty()) {
                    password.setError(" password required");
                } else if (password.getText().length() < 6) {
                    password.setError("password cant be less than 6 characters");
                } else {
                    Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
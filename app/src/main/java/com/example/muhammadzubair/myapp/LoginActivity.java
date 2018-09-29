package com.example.muhammadzubair.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // view reference
    private Button login_button, register_button;
    private EditText email_text, password_text;
    //private String v_email,v_password;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        /*Bundle b=intent.getExtras();
        v_email=b.getString("MyEmail");
        v_password=b.getString("MyPass");*/
        // initializing the views refernce with views object from xml
        login_button = findViewById(R.id.login_button);
        register_button = findViewById(R.id.register_button);
        email_text = findViewById(R.id.email_input);
        password_text = findViewById(R.id.password_input);
        // click listener for button
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email_text.getText().toString().trim().length() == 0){
                    email_text.setError("You Must Enter E-mail");
                    return;
                }
                if(password_text.getText().toString().trim().length() == 0){
                    password_text.setError("You Must Enter Password");
                    return;
                }
                if (email_text.getText().toString().trim().equals("ali@gmail.com")) {
                    if (password_text.getText().toString().trim().equals("malik1")) {
                        Intent obj = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(obj);
                    }
                    else{
                        password_text.setError("Invalid Password");
                        return;
                    }
                }
                else {
                    email_text.setError("Invalid E_mail");
                    return;
                }

            }
        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(obj);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        email_text.setText("");
        password_text.setText("");
    }
}

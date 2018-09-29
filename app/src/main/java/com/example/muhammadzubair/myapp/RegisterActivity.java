package com.example.muhammadzubair.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private Button register_button;
    private EditText F_Name_input,L_Name_input,email_input, password_input,confirm_password_input;
    //private String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // initializing the views refernce with views object from xml
        register_button = findViewById(R.id.Register_Button);
        F_Name_input = findViewById(R.id.F_Name_input);
        L_Name_input = findViewById(R.id.l_Name_input);
        email_input = findViewById(R.id.Email_input);
        password_input = findViewById(R.id.Password_input);
        confirm_password_input = findViewById(R.id.Confirm_Password_input);

        // click listener for button
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if ((F_Name_input.getText().toString().trim().length() == 0) || (L_Name_input.getText().toString().trim().length() == 0) || (email_input.getText().toString().trim().length() == 0) || (password_input.getText().toString().trim().length() == 0) || (confirm_password_input.getText().toString().trim().length() == 0)) {
                   Toast.makeText(RegisterActivity.this, " You Must Enter All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ( !password_input.getText().toString().equals(confirm_password_input.getText().toString())) {
                    password_input.setError("Password Doesn't Match");
                    confirm_password_input.setError("Password Doesn't Match");
                    return;
                }
                else if (password_input.getText().toString().trim().length() <=5 ) {
                    password_input.setError("Password length Should Be Greater Than 5");
                    return;
                }
                if (F_Name_input.getText().toString().equals(L_Name_input.getText().toString())) {
                    F_Name_input.setError("Fist Name & Last Name Must Be Different");
                    L_Name_input.setError("Fist Name & Last Name Must Be Different");
                    return;
                }
                Toast.makeText(RegisterActivity.this, " You Are Registered Sucessfully! ", Toast.LENGTH_SHORT).show();
                //email = email_input.getText().toString();
                //password = password_input.getText().toString();
                Intent obj = new Intent(RegisterActivity.this,LoginActivity.class);
                //obj.putExtra("MyEmail",email);
                //obj.putExtra("MyPass",password);
                startActivity(obj);
            }
        });
    }
}

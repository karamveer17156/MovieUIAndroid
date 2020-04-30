package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;
public class Login extends AppCompatActivity {
    Button sign_up, invertor_btn;
    FrameLayout signinbtn;
    ImageView img;
    EditText email, pass;
    public boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.user_email);
        pass = findViewById(R.id.user_pass);
        sign_up = (Button)findViewById(R.id.signup_btn);
        signinbtn = findViewById(R.id.login_btn);
        img = findViewById(R.id.img_icn);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(email.getText().toString().equals("") || pass.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Please enter all details",Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(email.getText().toString())){
                    Toast.makeText(Login.this, "Please enter Valid Email",Toast.LENGTH_SHORT).show();
                }else{
                    System.out.println("moving to new screen");
                    Intent intent = new Intent(getApplicationContext(), welcome_admin_animation.class);
                    startActivity(intent);
                }
            }
        });
        signinbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(email.getText().toString().equals("") || pass.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Please enter all details",Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(email.getText().toString())){
                    Toast.makeText(Login.this, "Please enter Valid Email",Toast.LENGTH_SHORT).show();
                }
                else{
                    String temp = String.valueOf(email.getText());
                    System.out.println("Email |"+temp+"| "+email.getText().toString().length());
                    System.out.println(email.getText());
                    Intent intent = new Intent(getApplicationContext(), screen_movie.class);
                    startActivity(intent);
                }
            }
        });
        invertor_btn = findViewById(R.id.investor_loginbtn);
        invertor_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(email.getText().toString().equals("") || pass.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Please enter all details",Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(email.getText().toString())){
                    Toast.makeText(Login.this, "Please enter Valid Email",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), Investor_animated.class);
                    startActivity(intent);
                }
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    TextView date;
    DatePickerDialog datePickerDialog;
    Button signupbtn;
    EditText fname, lname, email, pass, cpass, address, city, postal, phno;
    public boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupbtn = findViewById(R.id.signup_final);
        fname = findViewById(R.id.name);
        lname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        cpass = findViewById(R.id.confirmpassword);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        postal = findViewById(R.id.postal);
        phno = findViewById(R.id.phone);
        final String[] dob = new String[1];
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fname.getText().toString().equals("")|| lname.getText().toString().equals("") || email.getText().toString().equals("")||
                pass.getText().toString().equals("") || cpass.getText().toString().equals("") || address.getText().toString().equals("")||
                city.getText().toString().equals("") || postal.getText().toString().equals("") || phno.getText().toString().equals("")||
                        dob[0]==null || dob[0]==""){
                    Toast.makeText(SignUp.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(email.getText().toString())){
                    Toast.makeText(SignUp.this, "Please enter valid Email", Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent = new Intent(getApplicationContext(), Party_popper.class);
                    startActivity(intent);
                }
            }
        });
        date =  findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(SignUp.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                dob[0] = dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year;
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
}

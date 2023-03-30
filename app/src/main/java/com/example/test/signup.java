package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class signup extends AppCompatActivity {

    TextInputEditText EditTextfirstname,EditTextlastname,EditTextpassword,EditTextemail,EditTextPhone;
    AppCompatButton signUpBtn;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditTextfirstname=findViewById(R.id.firstName1);
        EditTextlastname=findViewById(R.id.lastName1);
        EditTextemail=findViewById(R.id.email1);
        EditTextpassword=findViewById(R.id.pass1);
        EditTextPhone=findViewById(R.id.phone1);
        signUpBtn=findViewById(R.id.signup_btn);
        login=findViewById(R.id.login_screen);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (  !validateEmail(EditTextemail) || !ValidPass(EditTextpassword) ||
                        !Validname(EditTextfirstname) || !Validname(EditTextlastname) ) {
                    validateEmail(EditTextemail);
                    ValidPass(EditTextpassword);
                    Validname(EditTextfirstname);
                    Validname(EditTextlastname);
                }
                else {
                    String firstName,lastName;
                    String password;
                    String email,phone;
                    firstName = String.valueOf(EditTextfirstname.getText());
                    lastName = String.valueOf(EditTextlastname.getText());
                    password = String.valueOf(EditTextpassword.getText());
                    email = String.valueOf(EditTextemail.getText());
                    phone = String.valueOf(EditTextPhone.getText());

                    if (!firstName.equals("") && !lastName.equals("") && !password.equals("")
                            && !email.equals("") && (!phone.equals("")  ) ) {

                        //Start ProgressBar first (Set visibility VISIBLE)
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //Starting Write and Read data with URL
                                //Creating array for parameters
                                String[] field = new String[9];
                                field[0] = "firstName";
                                field[1] = "lastName";
                                field[2]= "email";
                                field[3] = "password";
                                field[4] = "phone";

                                //Creating array for data
                                String[] data = new String[9];
                                data[0] = firstName;
                                data[1] =lastName;
                                data[2]= email;
                                data[3] = password;
                                data[4]= phone;


                                PutData putData = new PutData("http://192.168.43.25/StadyMasca/signup.php", "POST", field, data);
                                if (putData.startPut()) {

                                    if (putData.onComplete()) {
                                        String result = putData.getResult();
                                        if (result.equals("Sign Up Success")) {
                                            Toast toast= Toast.makeText(signup.this, "Sign Up Success", Toast.LENGTH_LONG);
                                            toast.getView().setBackgroundColor(Color.parseColor("#9ede73"));
                                            toast.show();


                                            Intent intent = new Intent(signup.this, login.class);
                                            startActivity(intent);
                                            finish();

                                        } else {
                                            Toast toast= Toast.makeText(signup.this, result, Toast.LENGTH_LONG);
                                            toast.getView().setBackgroundColor(Color.RED);
                                            toast.show();

                                        }
                                        //End ProgressBar (Set visibility to GONE)
                                    }
                                }
                                //End Write and Read data with URL
                            }
                        });
                    } else Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
                }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signup.this, login.class);
                startActivity(intent);
            }
        });
    }


    private Boolean validateEmail(TextInputEditText email) {
        String emailIn = email.getText().toString();
        if(!emailIn.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailIn).matches()){
            return true;
        }
        else {
            email.setError("enter a valid email address");
            return  false;
        }

    }
    private Boolean ValidPass(TextInputEditText pass){
        String passIN = pass.getText().toString();

        if(passIN.length()>5 || passIN.length()>21){

            return true;
        }
        else {
            pass.setError("between 6 and 20 characters ");

            return false;
        }
    }
    private Boolean Validname(TextInputEditText name) {
        String nameIN = name.getText().toString();
        String n1 = "[a-zA-Z]+";
        if (nameIN.length() > 3 || nameIN.equals(n1)) {

            return true;
        } else {
            name.setError("at least 3 characters and don't use numbers");

            return false;
        }
    }
}
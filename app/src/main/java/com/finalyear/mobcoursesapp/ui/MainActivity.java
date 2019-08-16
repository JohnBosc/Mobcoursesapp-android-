package com.finalyear.mobcoursesapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.finalyear.mobcoursesapp.Authentication.Signin;
import com.finalyear.mobcoursesapp.Authentication.Signup;
import com.finalyear.mobcoursesapp.R;

public class MainActivity extends AppCompatActivity {
    private Button buttonSignUp;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignIn = (Button) findViewById(R.id.signinbutton);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignin();
            }
        });


        buttonSignUp = (Button) findViewById(R.id.signupbutton);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });
    }

    public void openSignup(){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    public void openSignin(){
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }
}

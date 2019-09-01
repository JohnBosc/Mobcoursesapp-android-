package com.finalyear.mobcoursesapp.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.ui.BottomNav;
import com.finalyear.mobcoursesapp.ui.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;


public class Signin extends AppCompatActivity {


    private ImageView backtointro;
    private TextView resetPassword;
    private TextView RegText;
    private EditText UserEmail, UserPassword;
    Button btn_login;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        progressBar = findViewById(R.id.signin_progressbar);
        btn_login = findViewById(R.id.signinbtn);
        backtointro = (ImageView) findViewById(R.id.backtointro);
        resetPassword = (TextView) findViewById(R.id.resetPass);
        RegText = (TextView) findViewById(R.id.goToSignUp);
        UserEmail = findViewById(R.id.signinemail);
        UserPassword = findViewById(R.id.signinpassword);


        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, Signup.class);
                startActivity(intent);
            }
        });

        // [START back_to_intro_page]
        backtointro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToIntro();
            }
        });
        // [END back_to_intro_page]

//        btn_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpenLogin();
//            }
//        });


        // [START reset_password_activity]
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResetPass();
            }
        });

    }

    public void OnLogin(View view)
    {
        String useremail = UserEmail.getText().toString();
        String userpassword = UserPassword.getText().toString();
    }

    // [START back_to_intro_function]
    public void backToIntro() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // [END back_to_intro_activity]


    // [START reset_password_function]
    public void OpenResetPass() {
        Intent intentResetPass = new Intent(this, ResetPassword.class);
        startActivity(intentResetPass);
    }
    // [END reset_password_activity]


//    // [START reset_password_function]
//    public void OpenLogin() {
//        Intent intent = new Intent(this, BottomNav.class);
//        startActivity(intent);
//    }
//    // [END reset_password_activity]

}

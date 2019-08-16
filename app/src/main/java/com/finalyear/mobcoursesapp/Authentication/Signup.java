package com.finalyear.mobcoursesapp.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.entities.User;
import com.finalyear.mobcoursesapp.ui.BottomNav;
import com.finalyear.mobcoursesapp.ui.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {


    private EditText inputEmail, inputName, inputPhone, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;

    private ImageView backtointro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Back to the intro page
        backtointro = (ImageView) findViewById(R.id.signup_backtointro);
        backtointro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToIntro();
            }
        });

        btnSignUp = (Button) findViewById(R.id.signupbtn);
        inputName = (EditText) findViewById(R.id.fullname);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPhone = (EditText) findViewById(R.id.phone);
        inputPassword = (EditText) findViewById(R.id.pass);
        progressBar = findViewById(R.id.signup_progressbar);
        progressBar.setVisibility(View.GONE);

    }

    // Back to intro page function
    public void backToIntro() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

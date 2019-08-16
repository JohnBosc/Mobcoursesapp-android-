package com.finalyear.mobcoursesapp.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.finalyear.mobcoursesapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class ResetPassword extends AppCompatActivity {

    private ImageView backtosignin;

    private EditText inputEmail;

    private Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        backtosignin = (ImageView) findViewById(R.id.backtosignin);
        backtosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToSignin();
            }
        });


        // Reset Password
        inputEmail = (EditText) findViewById(R.id.reset_useremail);

        btnReset = (Button) findViewById(R.id.reset_btn);



    }

    private void backToSignin() {
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }
}

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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.Utils.Session;
import com.finalyear.mobcoursesapp.ui.BottomNav;
import com.finalyear.mobcoursesapp.ui.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Signin extends AppCompatActivity {


    private Context context;
    private ImageView backtointro;
    private TextView resetPassword;
    private TextView RegText;
    private EditText email, password;
    Button btn_login;
    ProgressBar loading;
    private static String URL_LOGIN = "http://192.168.1.104/mobcoursesapp/login.php";
    private Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        session = new Session(this);
        loading = findViewById(R.id.signin_progressbar);
        btn_login = findViewById(R.id.btn_login);
        backtointro = (ImageView) findViewById(R.id.backtointro);
        resetPassword = (TextView) findViewById(R.id.resetPass);
        RegText = (TextView) findViewById(R.id.goToSignUp);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

//        Toast.makeText(getApplicationContext(), "User Login Status: " + save.isUserLoggedIn(), Toast.LENGTH_SHORT).show();

        if (session.loggedIn()) {
            startActivity(new Intent(Signin.this, BottomNav.class));
            finish();
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()){
                    Login(mEmail, mPass);
                }else {
                    email.setError("Please insert email");
                    password.setError("Please insert password");
                }
            }
        });


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


        // [START reset_password_activity]
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenResetPass();
            }
        });

    }




    private void Login(String email, String password) {

        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);

        StringRequest stringRequest =  new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success =  jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String name = object.getString("name").trim();
                                    String email =  object.getString("email").trim();

                                    session.setLoggedIn(true);
                                    Intent I = new Intent(getApplicationContext(), BottomNav.class);
                                    startActivity(I);
                                    finish();
                                    loading.setVisibility(View.GONE);

                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(Signin.this, "Error " +e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(Signin.this, "Error " +error.toString(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

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

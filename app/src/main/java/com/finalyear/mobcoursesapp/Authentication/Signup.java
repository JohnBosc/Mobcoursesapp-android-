package com.finalyear.mobcoursesapp.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.entities.Student;
import com.finalyear.mobcoursesapp.ui.BottomNav;
import com.finalyear.mobcoursesapp.ui.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    private EditText name, email, phone, password;
    private Button btn_regist;
    private ProgressBar loading;
    private ImageView backtointro;
    private static String URL_REGIST = "http://192.168.1.104/mobcoursesapp/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        btn_regist = (Button) findViewById(R.id.signupbtn);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        loading = findViewById(R.id.signup_progressbar);
        loading.setVisibility(View.GONE);


        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();
            }
        });

        // Back to the intro page
        backtointro = (ImageView) findViewById(R.id.signup_backtointro);
        backtointro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToIntro();
            }
        });

    }

    // Back to intro page function
    public void backToIntro() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Regist(){
        loading.setVisibility(View.VISIBLE);
        btn_regist.setVisibility(View.GONE);

        final String name = this.name.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String phone = this.phone.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")){
                                Toast.makeText(Signup.this, "Sucessfully Register!", Toast.LENGTH_SHORT).show();
                                Intent I = new Intent(Signup.this, BottomNav.class);
                                startActivity(I);
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Signup.this, "Registration Error! " + e.toString(), Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                            btn_regist.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Signup.this, "Registration Error! " + error.toString(), Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_regist.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("phone", phone);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}

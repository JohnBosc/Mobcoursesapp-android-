package com.finalyear.mobcoursesapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.entities.Course;
import com.finalyear.mobcoursesapp.entities.Subject;
import com.finalyear.mobcoursesapp.ui.BottomNav;
import com.finalyear.mobcoursesapp.ui.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CatalogFragment extends Fragment {
    RecyclerView myrv;
    GridLayoutManager gridLayoutManager;
    SwipeRefreshLayout refreshLayout;
    RecyclerView.Adapter myAdapter;
    public static final RetryPolicy policy = new DefaultRetryPolicy(10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    List<Course> lstCourse;
    private static final String COURSE_URL= "http://192.168.1.104/mobcoursesapp/api.php";

    private static final String COURSE_URL2= "http://192.168.1.104/mobcoursesapp/api2.php"; // For the subjectID and courseID

    public CatalogFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void loadCourse() {
        JsonArrayRequest js = new JsonArrayRequest(COURSE_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i<response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int courseID = jsonObject.getInt("courseID");
                        String courseTitle  = jsonObject.getString("courseTitle");
                        int subjectID = jsonObject.getInt("subjectID");
                        int courseAuthorID = jsonObject.getInt("courseAuthorID");
                        String courseDescription = jsonObject.getString("courseDescription");
                        String otherDetails = jsonObject.getString("otherDetails");
                        String requirements = jsonObject.getString("requirements");
                        String photo = "http://192.168.1.104/mobcoursesapp/thumbnails/" + courseTitle + ".jpg";
                        lstCourse.add(new Course(courseID, courseTitle, subjectID, courseAuthorID,courseDescription,
                                otherDetails,requirements,photo));
//                        System.out.println(" ////////////////   "+courseAuthorID + " " + subjectID);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                myAdapter.notifyDataSetChanged();
//                System.out.println(" ////////////////   "+lstCourse.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Something went wrong.",Toast.LENGTH_LONG).show();
            }
        });
        js.setShouldCache(false);
         js.setRetryPolicy(policy)  ;
        Volley.newRequestQueue(getContext()).add(js);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("TestFailed","OnCreate");
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);

        refreshLayout = view.findViewById(R.id.swiperefresh);


        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("TestFailed","OnCreate");
        lstCourse = new ArrayList<>();

        myrv = (RecyclerView) view.findViewById(R.id.recyclerview_id);
        myAdapter = new RecyclerViewAdapter(this, lstCourse);
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        myrv.setLayoutManager(gridLayoutManager);
        myrv.setAdapter(myAdapter);

        loadCourse();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //implement update
                refreshLayout.setRefreshing(false);
            }
        });

    }
}
package com.finalyear.mobcoursesapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CatalogFragment extends Fragment {

    List<Course> lstCourse;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catalog, container, false);

        lstCourse = new ArrayList<>();
        lstCourse.add(new Course("The course 1", "The category 1", "Description 1", R.drawable.course1));
        lstCourse.add(new Course("The course 2", "The category 2", "Description 2", R.drawable.course2));
        lstCourse.add(new Course("The course 3", "The category 3", "Description 3", R.drawable.course3));
        lstCourse.add(new Course("The course 4", "The category 4", "Description 4", R.drawable.course4));
        lstCourse.add(new Course("The course 5", "The category 5", "Description 5", R.drawable.course5));
        lstCourse.add(new Course("The course 1", "The category 1", "Description 1", R.drawable.course1));
        lstCourse.add(new Course("The course 2", "The category 2", "Description 2", R.drawable.course2));
        lstCourse.add(new Course("The course 3", "The category 3", "Description 3", R.drawable.course3));
        lstCourse.add(new Course("The course 4", "The category 4", "Description 4", R.drawable.course4));
        lstCourse.add(new Course("The course 5", "The category 5", "Description 5", R.drawable.course5));
        lstCourse.add(new Course("The course 1", "The category 1", "Description 1", R.drawable.course1));
        lstCourse.add(new Course("The course 2", "The category 2", "Description 2", R.drawable.course2));
        lstCourse.add(new Course("The course 3", "The category 3", "Description 3", R.drawable.course3));
        lstCourse.add(new Course("The course 4", "The category 4", "Description 4", R.drawable.course4));
        lstCourse.add(new Course("The course 5", "The category 5", "Description 5", R.drawable.course5));


//        RecyclerView myrv = (RecyclerView)getActivity().findViewById(R.id.recyclerview_id);
//        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter((Context)getActivity(), lstCourse);
//        myrv.setLayoutManager(new GridLayoutManager((Context)getActivity(),3));
//        myrv.setAdapter(myAdapter);


        return view;


    }


}
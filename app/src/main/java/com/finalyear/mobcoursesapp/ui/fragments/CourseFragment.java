package com.finalyear.mobcoursesapp.ui.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.Utils.ImageLoader;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class CourseFragment extends Fragment {

    private TextView tvtitle, tvdescription, tvdetails, tvrequirement, tvSubject, enrollment;
    private ImageView coursePhoto;
    private int subjectID, courseAuthorID;
    String courseTitle,courseDescription, otherDetails, requirements, photo;

    private static final String COURSE_URL= "http://192.168.1.104/mobcoursesapp/api.php";

    public CourseFragment() {
    }

    public CourseFragment(int subjectID, int courseAuthorID, String courseTitle, String courseDescription, String otherDetails, String requirements, String photo) {
        this.subjectID = subjectID;
        this.courseAuthorID = courseAuthorID;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.otherDetails = otherDetails;
        this.requirements = requirements;
        this.photo = photo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);

        tvtitle = (TextView) view.findViewById(R.id.txttitle);
        tvdescription = (TextView) view.findViewById(R.id.txtDesc);
        tvSubject = (TextView) view.findViewById(R.id.txtCat);
        tvdetails = (TextView) view.findViewById(R.id.txtDetails);
        tvrequirement = (TextView) view.findViewById(R.id.txtRequirements);
        coursePhoto = (ImageView) view.findViewById(R.id.coursethumbnail);
        enrollment = (TextView) view.findViewById(R.id.enroll_now);



        // Setting values
        tvtitle.setText(courseTitle);
        tvdescription.setText(courseDescription);

        tvrequirement.setText(requirements);

        ImageLoader.loadImage(this.getContext(),photo,coursePhoto);

        tvdetails.setText(otherDetails);

//        tvSubject.setText(subjectID);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enrollment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement method read api and alter Student_Course table to add user to a course
                // Then load the mycourses fragment
            }
        });

    }
}

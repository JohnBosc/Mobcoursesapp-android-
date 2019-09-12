package com.finalyear.mobcoursesapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.finalyear.mobcoursesapp.R;
import com.finalyear.mobcoursesapp.Utils.ImageLoader;
import com.finalyear.mobcoursesapp.entities.Course;
import com.finalyear.mobcoursesapp.ui.fragments.CatalogFragment;
import com.finalyear.mobcoursesapp.ui.fragments.CourseFragment;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private List<Course> mData;
    private CatalogFragment catalogFragment;


    public RecyclerViewAdapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public RecyclerViewAdapter(CatalogFragment catalogFragment, List<Course> lstCourse) {
        this.catalogFragment = catalogFragment;
        this.mData = lstCourse;
        this.mContext = catalogFragment.getContext();
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(catalogFragment.getContext());
        view = mInflater.inflate(R.layout.cardview_item_course, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_course_title.setText(mData.get(position).getCourseTitle());
        ImageLoader.loadImage(mContext,"http://192.168.1.104/mobcoursesapp/thumbnails/" + mData.get(position).getCourseTitle() +
                ".jpg", holder.img_course_photo);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomNav bottomNav = (BottomNav)catalogFragment.getActivity();
                assert bottomNav != null;
                bottomNav.loadFragment(new CourseFragment(mData.get(position).getSubject(), mData.get(position).getCourseAuthor(), mData.get(position).getCourseTitle(),
                        mData.get(position).getCourseDescription(), mData.get(position).getOtherDetails(), mData.get(position).getRequirements(), mData.get(position).getPhoto()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_course_title;
        TextView tv_course_author;
        ImageView img_course_photo;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_course_title = (TextView) itemView.findViewById(R.id.course_title_id);
            tv_course_author = (TextView) itemView.findViewById(R.id.course_author);
            img_course_photo = (ImageView) itemView.findViewById(R.id.course_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

        }
    }


}

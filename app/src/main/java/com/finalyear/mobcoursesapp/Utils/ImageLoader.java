package com.finalyear.mobcoursesapp.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.finalyear.mobcoursesapp.R;
import com.squareup.picasso.Picasso;

public class ImageLoader {

    public static void loadImage(Context c, String url, ImageView img){
        if(url != null){
            Picasso.get().load(url).into(img);
        }else{
            Picasso.get().load(R.drawable.course5).into(img);
        }

    }

}

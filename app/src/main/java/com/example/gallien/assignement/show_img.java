package com.example.gallien.assignement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class show_img extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_img);
        imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }
}

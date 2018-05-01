package com.example.gallien.assignement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Callback;

public class Add_Data extends AppCompatActivity {


    private static String BASE_URL = "https://android-f21e8.firebaseio.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data_user);

        final String uid = getIntent().getStringExtra("uid");
        final String token = getIntent().getStringExtra("token");



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//url of firebase app
                .addConverterFactory(GsonConverterFactory.create())//use for convert JSON file into object
                .build();

        final Api api = retrofit.create(Api.class);//use of interface
        final TextView country = findViewById(R.id.countryField);
        final TextView cities = findViewById(R.id.citiesField);
        Button post = findViewById(R.id.post);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Call<User> call1 =api.setData(uid,"json",token, new User(country.getText().toString(), Arrays.asList(cities.getText().toString().split(","))));
                call1.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(Add_Data.this,token,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(Add_Data.this, "Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }

}

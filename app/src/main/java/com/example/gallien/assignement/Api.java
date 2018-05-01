package com.example.gallien.assignement;

/**
 * Created by Gallien on 17/04/2018.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Body;
import retrofit2.http.Query;

public interface Api {



    @PUT("/users/{uid}.{json}")
    Call<User> setData(@Path("uid") String s1,@Path("json") String json, @Query("auth") String token, @Body User user);

    @GET("/users/{uid}.{json}")
    Call<User> getData(@Path("uid") String uid, @Path("json")String json,@Query("auth") String token);
    //Call<User> getData(@Path("uid") String s1,@Path("json") String json);


}

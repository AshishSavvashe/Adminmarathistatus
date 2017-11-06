package com.example.admin.adminmarathistatus.Retrofit;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PartMap;

/**
 * Created by Admin on 06-11-2017.
 */

public interface WebServices {

    //catgoryfetch
    @GET("")
    void getallcatgory(Callback<String> callback);

    @Multipart
    @POST("/")
    void MessageInsert(@PartMap HashMap<String,Object> map,
                    Callback<String> callback);
}

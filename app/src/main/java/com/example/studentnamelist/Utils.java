package com.example.studentnamelist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {
    public static Api getApi(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://test.schoolman.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apis=retrofit.create(Api.class);
        return apis;

    }
}

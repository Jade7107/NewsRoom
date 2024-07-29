package com.mohit.newsroom;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// this is Api utilities to create a retrofit object
public class ApiUtilities {

    private static Retrofit retrofit=null;

    public  static ApiInterface getApiInterface(){

        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiInterface.class);
    }

}

package com.gahee.backstage.data.remote;

import com.gahee.backstage.data.API;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static com.gahee.backstage.data.API.BASE_URL;

public class RetrofitInstanceBuilder {

    private static final Retrofit.Builder retrofitBuilder =
    new Retrofit.Builder().baseUrl(BASE_URL)
    .addConverterFactory(SimpleXmlConverterFactory.create());

    private static final Retrofit retrofit
    = retrofitBuilder.build();

    private static final API api =
            retrofit.create(API.class);

    public static API getApi(){
        return api;
    }


}

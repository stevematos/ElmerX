package com.elmerx.taxisanmarcos.conexion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static final String API_BASE_URL = "https://stsm.herokuapp.com/";
    private static ApiAdapter instance = null;
    private static Retrofit retrofit = null;
    private static Gson gson = new GsonBuilder().create();

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor);

    private static OkHttpClient okHttpClient = okHttpClientBuilder.build();

    public static ApiAdapter getInstance() {
        if (instance == null)
            instance = new ApiAdapter();
        return instance;
    }

    public <T> T createService(Class<T> serviceClass){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(serviceClass);
    }

    /*public static <T> T createService(Class<T> serviceClass){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(serviceClass);
    }*/

}

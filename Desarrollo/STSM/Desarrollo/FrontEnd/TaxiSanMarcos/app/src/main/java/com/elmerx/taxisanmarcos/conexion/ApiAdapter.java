package com.elmerx.taxisanmarcos.conexion;

public class ApiAdapter {

    private static final String API_BASE_URL = "https://stsm.herokuapp.com/";
    private static ApiAdapter instance = null;
    //private static Retrofit retrofit = null;

    public static ApiAdapter getInstance() {
        if (instance == null)
            instance = new ApiAdapter();
        return instance;
    }

    public static <T> T createService(Class<T> serviceClass){
        /*if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .build();
        }
        return retrofit.create(serviceClass);*/
        return null;
    }

}

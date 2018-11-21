package com.elmerx.taxisanmarcos.conexion;

//import retrofit2.Call;
import com.elmerx.taxisanmarcos.modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/usuario/add")
    @Headers({"Accept: application/json"})
    Call<Usuario> registrarUsuario(@Body Usuario request);

    @POST("/usuario/update")
    @Headers({"Accept: application/json"})
    Call<Usuario> updateUsuario(@Body Usuario request);
}

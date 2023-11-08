package com.miprimeraapp.pruebaconexion.interfaces;

import com.miprimeraapp.pruebaconexion.models.Cancha;
import com.miprimeraapp.pruebaconexion.models.Direccion;
import com.miprimeraapp.pruebaconexion.models.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductAPI {


    //Obtener un usuario funciona
    @GET("usuario/{correo}")
    Call<Usuario> find(@Path("correo") String correo);

    //Obtener direccion de una cancha
    @GET("canchas/direccion/")
    Call<ArrayList<Direccion>> getDireccion();

    //listas de canchas
    @GET("/canchas/name")
    Call<ArrayList<Cancha>> getCanchas();

    //Registrar un usuario
    //Funciona
    @POST("usuario/registrar")
    Call<Usuario> addUsuario(@Body Usuario usuario);


    //usuario/login2/?correo=crisgonos1532@gmail.com&contraseña=Cris1532-
    //funciona
    @GET("/usuario/login2")
    Call<String> login(@Query("correo")String correo,
                       @Query("contraseña")String contraseña);

    @Headers("Accept:application/json")
    @GET("/canchas/parqueadero")
    Call<Cancha> parqueadero(@Query("parqueadero")boolean parqueadero,
                             @Query("id_cancha")long id_cancha);

    /*
    @POST("/upload/{nameImg}")
    @Multipart
    Call<Void> uploadPhoto(@Part Multipart.Part file);*/

}

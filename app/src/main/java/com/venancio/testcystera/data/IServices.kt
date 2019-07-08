package com.venancio.testcystera.data

import com.google.gson.JsonObject
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.QueryMap
import retrofit2.http.GET




interface IServices {

    @GET("MPTCH/Consulta/{numerodoc}")//se define de la sigiente manera para el consumo del ws
    fun getStringResponse(@Path("numerodoc") numerodoc:String): Call<JsonRespuestaUser>



    @GET("timezoneJSON")//se define de la sigiente manera para el consumo del ws
    fun getStringResponser(@Query   ("formatted")formatted : String,
                           @Query   ("lat") lat : String,
                           @Query   ("lng") lng : String,
                           @Query   ("username") username : String,
                           @Query   ("style") style : String): Call<JsonObject> @GET("timezoneJSON")//se define de la sigiente manera para el consumo del ws
    fun getStringResponse(@Query   ("formatted")formatted : String,
                           @Query   ("lat") lat : String,
                           @Query   ("lng") lng : String,
                           @Query   ("username") username : String,
                           @Query   ("style") style : String): Deferred<Response<JsonObject>>
    @GET()
    fun getStringResponsers(@Body Url:String): Deferred<Response<JsonObject>>


    @POST("MPTCH/Parametro")//se define de la sigiente manera para el consumo del ws
    fun ResponsedataMicroblink(@Body parameter: Parameter): Deferred<Response<JsonObject>>
}
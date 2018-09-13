package ar.uba.fi.tallerii.comprameli.api.root.services

import ar.uba.fi.tallerii.comprameli.api.root.model.HelloWorld
import ar.uba.fi.tallerii.comprameli.api.root.model.Ping
import retrofit2.Call
import retrofit2.http.GET

interface RootServices {

    @GET("ping")
    fun getPing() : Call<Ping>

    @GET("hello")
    fun getHello() : Call<HelloWorld>

    @GET("stats")
    fun getStats() : Call<HelloWorld>
}
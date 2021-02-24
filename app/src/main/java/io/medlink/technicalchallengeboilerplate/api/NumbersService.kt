package io.medlink.technicalchallengeboilerplate.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

public interface NumbersService {
    //done/ TODO: Adapt the service to the rest API

    @Headers("360medlink-custom:test")
    @GET("generate")
    fun generateRandomNumbers(): Call<RandomNumbers>

}
package io.medlink.technicalchallengeboilerplate.api

import retrofit2.Call

interface NumbersService {

    // TODO: Adapt the service to the rest API
    fun generateRandomNumbers(): Call<String>

}
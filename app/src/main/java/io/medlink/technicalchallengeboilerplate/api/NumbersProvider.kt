package io.medlink.technicalchallengeboilerplate.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NumbersDataSource {
    fun onFailure(error: String)
    fun onSuccess(numbers: List<Int>)
}

class NumbersProvider
constructor(
    val numbersDataSource: NumbersDataSource
) {
    init {
        provideNumbers()
    }

    private fun provideNumbers() {
        val service =
            ServiceBuilder.buildService(
                NumbersService::class.java
            )

        val call = service.generateRandomNumbers()

        call.enqueue(object : Callback<String> {
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        numbersDataSource.onSuccess(
                            // TODO: Remove empty list and add the proper response from the api
                            emptyList()
                        )
                    }
                } else {
                    numbersDataSource.onFailure("Failed to get random input")
                }

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                numbersDataSource.onFailure("Failed to get random input")
            }
        })
    }
}
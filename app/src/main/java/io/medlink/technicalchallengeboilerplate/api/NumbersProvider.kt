package io.medlink.technicalchallengeboilerplate.api

import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NumbersDataSource {
    fun onFailure(error: String)
    fun onSuccess(numbers: List<Int>)
}

class NumbersProvider
constructor(
    val numbersDataSource: NumbersDataSource)
{
    init {

        provideNumbers()
    }

    private fun provideNumbers() {
        val service = ServiceBuilder.getServiceClass( NumbersService::class.java
            )
        val call = service!!.generateRandomNumbers()
        call.enqueue( object : Callback<RandomNumbers> {
            override fun onResponse(
                call: Call<RandomNumbers>,
                response: Response<RandomNumbers>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        numbersDataSource.onSuccess(it.randomInput)
                    }

                } else {
                    numbersDataSource.onFailure("Failed to get random input")
                }

            }


            override fun onFailure(call: Call<RandomNumbers>, t: Throwable) {
            }
        })
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<NumbersService>) {

}

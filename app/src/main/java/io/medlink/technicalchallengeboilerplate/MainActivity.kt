package io.medlink.technicalchallengeboilerplate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.medlink.technicalchallengeboilerplate.api.NumbersDataSource
import io.medlink.technicalchallengeboilerplate.api.NumbersProvider
import io.thinkit.technicalchallengeboilerplate.R

class MainActivity : AppCompatActivity(),
    NumbersDataSource {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NumbersProvider(this)
    }

    override fun onSuccess(numbers: List<Int>) {
        Log.v("Response", numbers.toString())
        //TODO: Start your challenge from here

    }

    override fun onFailure(error: String) {
        Log.e("Error", error)
    }
}
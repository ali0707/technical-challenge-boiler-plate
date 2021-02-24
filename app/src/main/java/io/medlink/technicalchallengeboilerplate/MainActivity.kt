package io.medlink.technicalchallengeboilerplate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.medlink.technicalchallengeboilerplate.api.NumbersDataSource
import io.medlink.technicalchallengeboilerplate.api.NumbersProvider
import io.medlink.technicalchallengeboilerplate.api.NumbersService
import io.medlink.technicalchallengeboilerplate.api.ServiceBuilder
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
        println("Original")
        println(numbers[0])
        println(numbers[1])
        println(numbers[2])

        val num = numbers[0]
        val num1 = numbers[1]
        val num3 = numbers[2]
        for (i in 0 .. 2) {
            if (i==0){

                val test = num1 * num3
                println("Transformed 1")
                println(test)
            }
             if (i==1)
            {
                val test = num3 * num
                println("Transformed2 pos 2")
                println(test)
            }
            if(i==2)
            {
                println("Transformed 3")
                val test = num * num1
                println(test)

            }

        }


        ServiceBuilder.getServiceClass(NumbersService::class.java)!!.generateRandomNumbers()
        println("xxxx")
        println(ServiceBuilder.getServiceClass(NumbersService::class.java)!!.generateRandomNumbers())

    }

    override fun onFailure(error: String) {
        Log.e("Error", error)
    }
}

private operator fun <E> List<E>.get(int: Int.Companion) {

}

package io.medlink.technicalchallengeboilerplate.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RandomNumbers (

    @SerializedName("randomInput")
    val randomInput :List<Int>

)
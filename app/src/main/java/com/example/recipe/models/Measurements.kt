package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Measurements {
    @SerializedName("metric")
    var metric: Measurement? = null
    @SerializedName("us")
    var us: Measurement? = null
}
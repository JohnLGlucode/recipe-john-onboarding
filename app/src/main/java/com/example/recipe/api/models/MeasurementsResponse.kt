package com.example.recipe.api.models

import com.google.gson.annotations.SerializedName

class MeasurementsResponse {
    @SerializedName("metric")
    var metric: MeasurementResponse? = null
    @SerializedName("us")
    var us: MeasurementResponse? = null
}
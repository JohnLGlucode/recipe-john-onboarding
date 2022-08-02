package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Ingredient {
    @SerializedName("aisle")
    var aisle: String? = null
    @SerializedName("amount")
    var amount: Double = 0.0
    @SerializedName("consitency")
    var consistency: String? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("image")
    var image: String? = null
    @SerializedName("measures")
    var measures: Measurements? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("original")
    var original: String? = null
    @SerializedName("originalName")
    var originalName: String? = null
}
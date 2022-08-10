package com.example.recipe.models

import com.google.gson.annotations.SerializedName

class Ingredient {
    @SerializedName("aisle")
    var aisle: String? = null
    @SerializedName("image")
    var image: String? = null
    @SerializedName("measures")
    var measures: Measurements? = null
    @SerializedName("name")
    var name: String? = null
}
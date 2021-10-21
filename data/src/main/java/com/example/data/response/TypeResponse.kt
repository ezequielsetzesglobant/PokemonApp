package com.example.data.response

import com.google.gson.annotations.SerializedName

data class TypeResponse(
    @SerializedName("data")
    val data: List<String> = emptyList(),
)

package com.example.data.mapper

import com.example.data.database.entity.TypeEntity
import com.example.data.response.TypeResponse

fun TypeResponse.transformResponseToEntity() = TypeEntity(
    data = this.data.map { it }
)

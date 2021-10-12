package com.example.data.mapper

import com.example.data.database.entity.TypeEntity
import com.example.domain.entity.TypeData

fun TypeEntity.transformEntityToData() = TypeData(
    data = this.data.map { it }
)

package com.example.domain.entity

import java.io.Serializable

data class TypeData(
    val data: List<String> = emptyList(),
) : Serializable

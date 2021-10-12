package com.example.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TypeEntity(
    @PrimaryKey
    @ColumnInfo(name = "data")
    val data: List<String> = emptyList(),
)

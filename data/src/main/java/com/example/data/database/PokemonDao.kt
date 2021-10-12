package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entity.TypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTypes(typeEntity: TypeEntity)

    @Query("SELECT * FROM TypeEntity LIMIT 1")
    fun getTypes(): Flow<TypeEntity>
}

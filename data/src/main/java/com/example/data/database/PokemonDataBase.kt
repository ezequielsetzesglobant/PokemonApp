package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.utils.ListConverter
import com.example.data.database.entity.TypeEntity

@Database(entities = [TypeEntity::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class PokemonDataBase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object {

        private var instance: PokemonDataBase? = null

        fun getInstance(context: Context): PokemonDataBase? {
            if (instance == null) {
                synchronized(PokemonDataBase::class) {
                    instance = buildRoomDataBase(context)
                }
            }
            return instance
        }

        private fun buildRoomDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PokemonDataBase::class.java,
                DATABASE_NAME
            ).build()

        private const val DATABASE_NAME = "Pokemon database"
    }
}

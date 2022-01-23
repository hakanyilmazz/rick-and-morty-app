package com.hakanyilmazz.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hakanyilmazz.rickandmorty.data.db.dao.CartoonCharacterDao
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.data.model.Origin

@Database(
    entities = [
        CartoonCharacter::class,
        Origin::class
    ],
    version = 1,
    exportSchema = false
)
abstract class RickAndMortyDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "rick_and_morty_db"
    }

    abstract fun cartoonCharacterDao(): CartoonCharacterDao
}
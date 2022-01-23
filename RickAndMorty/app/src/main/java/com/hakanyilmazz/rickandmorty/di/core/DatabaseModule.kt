package com.hakanyilmazz.rickandmorty.di.core

import android.content.Context
import androidx.room.Room
import com.hakanyilmazz.rickandmorty.data.db.RickAndMortyDatabase
import com.hakanyilmazz.rickandmorty.data.db.dao.CartoonCharacterDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideCartoonCharacterDatabase(context: Context): RickAndMortyDatabase {
        return Room.databaseBuilder(context, RickAndMortyDatabase::class.java, RickAndMortyDatabase.DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun provideCartoonCharacterDao(rickAndMortyDatabase: RickAndMortyDatabase): CartoonCharacterDao {
        return rickAndMortyDatabase.cartoonCharacterDao()
    }
}
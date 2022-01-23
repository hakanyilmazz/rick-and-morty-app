package com.hakanyilmazz.rickandmorty.di.core

import com.hakanyilmazz.rickandmorty.data.db.dao.CartoonCharacterDao
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterLocalDataSource
import com.hakanyilmazz.rickandmorty.data.repository.datasourceimpl.CartoonCharacterLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideCartoonCharacterLocalDatasource(cartoonCharacterDao: CartoonCharacterDao): CartoonCharacterLocalDataSource {
        return CartoonCharacterLocalDataSourceImpl(cartoonCharacterDao, Dispatchers.IO)
    }
}
package com.hakanyilmazz.rickandmorty.di.core

import com.hakanyilmazz.rickandmorty.data.api.RickAndMortyService
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterRemoteDataSource
import com.hakanyilmazz.rickandmorty.data.repository.datasourceimpl.CartoonCharacterRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideCartoonCharacterRemoteDataSource(rickAndMortyService: RickAndMortyService): CartoonCharacterRemoteDataSource {
        return CartoonCharacterRemoteDataSourceImpl(rickAndMortyService)
    }
}
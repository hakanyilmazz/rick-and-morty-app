package com.hakanyilmazz.rickandmorty.di.core

import com.hakanyilmazz.rickandmorty.data.repository.CartoonCharacterRepositoryImpl
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterCacheDataSource
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterLocalDataSource
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterRemoteDataSource
import com.hakanyilmazz.rickandmorty.domain.repository.CartoonCharacterRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCartoonCharacterRepository(
        cartoonCharacterCacheDataSource: CartoonCharacterCacheDataSource,
        cartoonCharacterLocalDataSource: CartoonCharacterLocalDataSource,
        cartoonCharacterRemoteDataSource: CartoonCharacterRemoteDataSource
    ): CartoonCharacterRepository {
        return CartoonCharacterRepositoryImpl(
            cartoonCharacterCacheDataSource,
            cartoonCharacterLocalDataSource,
            cartoonCharacterRemoteDataSource
        )
    }
}
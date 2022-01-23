package com.hakanyilmazz.rickandmorty.di.core

import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterCacheDataSource
import com.hakanyilmazz.rickandmorty.data.repository.datasourceimpl.CartoonCharacterCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideCartoonCharacterCacheDatasource(): CartoonCharacterCacheDataSource {
        return CartoonCharacterCacheDataSourceImpl()
    }
}
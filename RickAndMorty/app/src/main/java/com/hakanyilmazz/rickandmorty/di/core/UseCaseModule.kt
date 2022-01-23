package com.hakanyilmazz.rickandmorty.di.core

import com.hakanyilmazz.rickandmorty.domain.repository.CartoonCharacterRepository
import com.hakanyilmazz.rickandmorty.domain.usecase.GetCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.domain.usecase.UpdateCartoonCharacterUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetCartoonCharacterUseCase(cartoonCharacterRepository: CartoonCharacterRepository): GetCartoonCharacterUseCase {
        return GetCartoonCharacterUseCase(cartoonCharacterRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateCartoonCharacterUseCase(cartoonCharacterRepository: CartoonCharacterRepository): UpdateCartoonCharacterUseCase {
        return UpdateCartoonCharacterUseCase(cartoonCharacterRepository)
    }
}
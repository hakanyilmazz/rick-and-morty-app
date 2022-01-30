package com.hakanyilmazz.rickandmorty.di.cartooncharacter

import com.hakanyilmazz.rickandmorty.domain.usecase.GetCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.domain.usecase.UpdateCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.ui.cartooncharacter.CartoonCharacterViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CartoonCharacterModule {

    @CartoonCharacterScope
    @Provides
    fun provideCartoonCharacterViewModelFactory(
        getCartoonCharacterUseCase: GetCartoonCharacterUseCase,
        updateCartoonCharacterUseCase: UpdateCartoonCharacterUseCase
    ): CartoonCharacterViewModelFactory {
        return CartoonCharacterViewModelFactory(
            getCartoonCharacterUseCase,
            updateCartoonCharacterUseCase
        )
    }
}
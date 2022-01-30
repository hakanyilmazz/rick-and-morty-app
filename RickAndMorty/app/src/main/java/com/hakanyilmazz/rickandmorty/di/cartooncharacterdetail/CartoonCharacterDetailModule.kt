package com.hakanyilmazz.rickandmorty.di.cartooncharacterdetail

import com.hakanyilmazz.rickandmorty.ui.cartooncharacterdetail.CartoonCharacterDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CartoonCharacterDetailModule {

    @CartoonCharacterDetailScope
    @Provides
    fun provideCartoonCharacterDetailViewModelFactory(): CartoonCharacterDetailViewModelFactory {
        return CartoonCharacterDetailViewModelFactory()
    }
}
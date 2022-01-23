package com.hakanyilmazz.rickandmorty.di.cartooncharacter

import com.hakanyilmazz.rickandmorty.ui.cartooncharacterdetail.CartoonCharacterDetailFragment
import dagger.Subcomponent

@CartoonCharacterDetailScope
@Subcomponent(modules = [CartoonCharacterModule::class])
interface CartoonCharacterDetailSubcomponent {
    fun inject(cartoonCharacterDetailFragment: CartoonCharacterDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CartoonCharacterDetailSubcomponent
    }
}
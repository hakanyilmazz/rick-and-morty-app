package com.hakanyilmazz.rickandmorty.di.cartooncharacterdetail

import com.hakanyilmazz.rickandmorty.ui.cartooncharacterdetail.CartoonCharacterDetailFragment
import dagger.Subcomponent

@CartoonCharacterDetailScope
@Subcomponent(modules = [CartoonCharacterDetailModule::class])
interface CartoonCharacterDetailSubcomponent {
    fun inject(cartoonCharacterDetailFragment: CartoonCharacterDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CartoonCharacterDetailSubcomponent
    }
}
package com.hakanyilmazz.rickandmorty.di.cartooncharacter

import com.hakanyilmazz.rickandmorty.ui.cartooncharacter.CartoonCharacterFragment
import dagger.Subcomponent

@CartoonCharacterScope
@Subcomponent(modules = [CartoonCharacterModule::class])
interface CartoonCharacterSubComponent {
    fun inject(cartoonCharacterFragment: CartoonCharacterFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CartoonCharacterSubComponent
    }
}
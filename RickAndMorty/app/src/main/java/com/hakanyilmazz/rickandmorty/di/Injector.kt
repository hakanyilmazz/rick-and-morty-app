package com.hakanyilmazz.rickandmorty.di

import com.hakanyilmazz.rickandmorty.di.cartooncharacter.CartoonCharacterDetailSubcomponent
import com.hakanyilmazz.rickandmorty.di.cartooncharacter.CartoonCharacterSubComponent

interface Injector {
    fun createCartoonCharacterSubcomponent(): CartoonCharacterSubComponent
    fun createCartoonCharacterDetailSubcomponent(): CartoonCharacterDetailSubcomponent
}
package com.hakanyilmazz.rickandmorty.di

import com.hakanyilmazz.rickandmorty.di.cartooncharacter.CartoonCharacterSubComponent
import com.hakanyilmazz.rickandmorty.di.cartooncharacterdetail.CartoonCharacterDetailSubcomponent
import com.hakanyilmazz.rickandmorty.di.competition.CompetitionSubcomponent

interface Injector {
    fun createCartoonCharacterSubcomponent(): CartoonCharacterSubComponent
    fun createCartoonCharacterDetailSubcomponent(): CartoonCharacterDetailSubcomponent
    fun createCompetitionSubcomponent(): CompetitionSubcomponent
}
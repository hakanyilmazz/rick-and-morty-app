package com.hakanyilmazz.rickandmorty.di.core

import com.hakanyilmazz.rickandmorty.di.cartooncharacter.CartoonCharacterSubComponent
import com.hakanyilmazz.rickandmorty.di.cartooncharacterdetail.CartoonCharacterDetailSubcomponent
import com.hakanyilmazz.rickandmorty.di.competition.CompetitionSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DatabaseModule::class,
        CacheDataModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun cartoonCharacterSubcomponent(): CartoonCharacterSubComponent.Factory
    fun cartoonCharacterDetailSubcomponent(): CartoonCharacterDetailSubcomponent.Factory
    fun competitionSubcomponent(): CompetitionSubcomponent.Factory
}
package com.hakanyilmazz.rickandmorty.di.core

import android.content.Context
import com.hakanyilmazz.rickandmorty.di.cartooncharacter.CartoonCharacterSubComponent
import com.hakanyilmazz.rickandmorty.di.cartooncharacterdetail.CartoonCharacterDetailSubcomponent
import com.hakanyilmazz.rickandmorty.di.competition.CompetitionSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        CartoonCharacterSubComponent::class,
        CartoonCharacterDetailSubcomponent::class,
        CompetitionSubcomponent::class
    ]
)
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}
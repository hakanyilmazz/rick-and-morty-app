package com.hakanyilmazz.rickandmorty.di.competition

import com.hakanyilmazz.rickandmorty.ui.competition.CompetitionViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CompetitionModule {
    @CompetitionScope
    @Provides
    fun provideCompetitionViewModelFactory(): CompetitionViewModelFactory {
        return CompetitionViewModelFactory()
    }
}
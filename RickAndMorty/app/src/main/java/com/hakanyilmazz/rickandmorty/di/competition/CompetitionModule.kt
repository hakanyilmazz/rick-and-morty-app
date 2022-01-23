package com.hakanyilmazz.rickandmorty.di.competition

import com.hakanyilmazz.rickandmorty.domain.usecase.UpdateCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.ui.competition.CompetitionViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CompetitionModule {
    @CompetitionScope
    @Provides
    fun provideCompetitionViewModelFactory(
        updateCartoonCharacterUseCase: UpdateCartoonCharacterUseCase
    ): CompetitionViewModelFactory {
        return CompetitionViewModelFactory(updateCartoonCharacterUseCase)
    }
}
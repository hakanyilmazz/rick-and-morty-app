package com.hakanyilmazz.rickandmorty.di.competition

import com.hakanyilmazz.rickandmorty.ui.competition.CompetitionFragment
import dagger.Subcomponent

@CompetitionScope
@Subcomponent(modules = [CompetitionModule::class])
interface CompetitionSubcomponent {
    fun inject(competitionFragment: CompetitionFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CompetitionSubcomponent
    }
}
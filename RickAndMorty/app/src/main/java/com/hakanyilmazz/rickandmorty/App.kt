package com.hakanyilmazz.rickandmorty

import android.app.Application
import com.hakanyilmazz.rickandmorty.di.Injector
import com.hakanyilmazz.rickandmorty.di.cartooncharacter.CartoonCharacterSubComponent
import com.hakanyilmazz.rickandmorty.di.cartooncharacterdetail.CartoonCharacterDetailSubcomponent
import com.hakanyilmazz.rickandmorty.di.competition.CompetitionSubcomponent
import com.hakanyilmazz.rickandmorty.di.core.AppComponent
import com.hakanyilmazz.rickandmorty.di.core.AppModule
import com.hakanyilmazz.rickandmorty.di.core.DaggerAppComponent
import com.hakanyilmazz.rickandmorty.di.core.NetModule

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .build()
    }

    override fun createCartoonCharacterSubcomponent(): CartoonCharacterSubComponent {
        return appComponent.cartoonCharacterSubcomponent().create()
    }

    override fun createCartoonCharacterDetailSubcomponent(): CartoonCharacterDetailSubcomponent {
        return appComponent.cartoonCharacterDetailSubcomponent().create()
    }

    override fun createCompetitionSubcomponent(): CompetitionSubcomponent {
        return appComponent.competitionSubcomponent().create()
    }
}
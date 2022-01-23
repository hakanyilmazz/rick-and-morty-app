package com.hakanyilmazz.rickandmorty.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CompetitionViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompetitionViewModel::class.java)) {
            return CompetitionViewModel() as T
        }

        throw IllegalArgumentException("Cannot create view model for ${modelClass.name}")
    }
}
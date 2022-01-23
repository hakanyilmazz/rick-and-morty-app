package com.hakanyilmazz.rickandmorty.ui.cartooncharacterdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CartoonCharacterDetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartoonCharacterDetailViewModel::class.java)) {
            return CartoonCharacterDetailViewModel() as T
        }

        throw IllegalArgumentException("Cannot create view model for ${modelClass.name}")
    }
}
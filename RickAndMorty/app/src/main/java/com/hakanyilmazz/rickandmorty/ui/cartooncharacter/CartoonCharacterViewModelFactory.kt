package com.hakanyilmazz.rickandmorty.ui.cartooncharacter

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hakanyilmazz.rickandmorty.domain.usecase.GetCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.domain.usecase.UpdateCartoonCharacterUseCase

class CartoonCharacterViewModelFactory(
    private val getCartoonCharacterUseCase: GetCartoonCharacterUseCase,
    private val updateCartoonCharacterUseCase: UpdateCartoonCharacterUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartoonCharacterViewModel::class.java)) {
            return CartoonCharacterViewModel(getCartoonCharacterUseCase, updateCartoonCharacterUseCase) as T
        }

        throw IllegalArgumentException("Cannot create view model for ${modelClass.name}")
    }
}
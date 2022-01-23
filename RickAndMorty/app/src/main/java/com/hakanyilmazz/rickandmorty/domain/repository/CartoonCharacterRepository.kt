package com.hakanyilmazz.rickandmorty.domain.repository

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter

interface CartoonCharacterRepository {
    suspend fun getCartoonCharacters(page: Int): List<CartoonCharacter>?
    suspend fun updateCartoonCharacters(page: Int): List<CartoonCharacter>?
}
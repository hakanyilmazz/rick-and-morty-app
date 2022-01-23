package com.hakanyilmazz.rickandmorty.data.repository.datasource

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter

interface CartoonCharacterLocalDataSource {
    suspend fun getCartoonCharactersFromDatabase(): List<CartoonCharacter>
    suspend fun saveCartoonCharactersToDatabase(cartoonCharacters: List<CartoonCharacter>)
    suspend fun clearAll()
}
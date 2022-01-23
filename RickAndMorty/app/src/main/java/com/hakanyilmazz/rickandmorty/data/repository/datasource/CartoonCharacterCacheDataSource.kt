package com.hakanyilmazz.rickandmorty.data.repository.datasource

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter

interface CartoonCharacterCacheDataSource {
    suspend fun getCartoonCharactersFromCache(): List<CartoonCharacter>
    suspend fun saveCartoonCharactersToCache(cartoonCharacters: List<CartoonCharacter>)
}
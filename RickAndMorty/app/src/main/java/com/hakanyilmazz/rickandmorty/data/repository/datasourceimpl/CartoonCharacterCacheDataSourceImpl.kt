package com.hakanyilmazz.rickandmorty.data.repository.datasourceimpl

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterCacheDataSource

class CartoonCharacterCacheDataSourceImpl() : CartoonCharacterCacheDataSource {
    private val cartoonCharacterList = ArrayList<CartoonCharacter>()

    override suspend fun getCartoonCharactersFromCache(): List<CartoonCharacter> {
        return cartoonCharacterList
    }

    override suspend fun saveCartoonCharactersToCache(cartoonCharacters: List<CartoonCharacter>) {
        cartoonCharacterList.clear()
        cartoonCharacterList.addAll(cartoonCharacters)
    }
}
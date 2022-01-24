package com.hakanyilmazz.rickandmorty.data.repository

import android.util.Log
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterCacheDataSource
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterLocalDataSource
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterRemoteDataSource
import com.hakanyilmazz.rickandmorty.domain.repository.CartoonCharacterRepository

class CartoonCharacterRepositoryImpl(
    private val cartoonCharacterCacheDataSource: CartoonCharacterCacheDataSource,
    private val cartoonCharacterLocalDataSource: CartoonCharacterLocalDataSource,
    private val cartoonCharacterRemoteDataSource: CartoonCharacterRemoteDataSource
) : CartoonCharacterRepository {
    override suspend fun getCartoonCharacters(page: Int): List<CartoonCharacter>? {
        return getCartoonCharactersFromCache(page)
    }

    override suspend fun updateCartoonCharacters(page: Int): List<CartoonCharacter>? {
        val newListOfCartoonCharacters = getCartoonCharactersFromApi(page)
        cartoonCharacterLocalDataSource.clearAll()
        cartoonCharacterLocalDataSource.saveCartoonCharactersToDatabase(newListOfCartoonCharacters)
        cartoonCharacterCacheDataSource.saveCartoonCharactersToCache(newListOfCartoonCharacters)
        return newListOfCartoonCharacters
    }

    private suspend fun getCartoonCharactersFromApi(page: Int): List<CartoonCharacter> {
        lateinit var cartoonCharacterList: List<CartoonCharacter>

        try {
            val response = cartoonCharacterRemoteDataSource.getCartoonCharactersFromApi(page)
            val body = response.body()

            cartoonCharacterList = body?.cartoonCharacters ?: listOf()

        } catch (exception: Exception) {
            Log.e("ERROR", exception.message.toString())
        }

        return cartoonCharacterList
    }

    private suspend fun getCartoonCharactersFromDatabase(page: Int): List<CartoonCharacter> {
        lateinit var cartoonCharacterList: List<CartoonCharacter>

        try {
            cartoonCharacterList =
                cartoonCharacterLocalDataSource.getCartoonCharactersFromDatabase()
        } catch (exception: Exception) {
            Log.e("ERROR", exception.message.toString())
        }

        if (cartoonCharacterList.isNullOrEmpty()) {
            cartoonCharacterList = getCartoonCharactersFromApi(page)
            cartoonCharacterLocalDataSource.saveCartoonCharactersToDatabase(cartoonCharacterList)
        }

        return cartoonCharacterList
    }

    private suspend fun getCartoonCharactersFromCache(page: Int): List<CartoonCharacter> {
        lateinit var cartoonCharacterList: List<CartoonCharacter>

        try {
            cartoonCharacterList = cartoonCharacterCacheDataSource.getCartoonCharactersFromCache()
        } catch (exception: Exception) {
            Log.e("ERROR", exception.message.toString())
        }

        if (cartoonCharacterList.isNullOrEmpty()) {
            cartoonCharacterList = getCartoonCharactersFromDatabase(page)
            cartoonCharacterCacheDataSource.saveCartoonCharactersToCache(cartoonCharacterList)
        }

        return cartoonCharacterList
    }
}
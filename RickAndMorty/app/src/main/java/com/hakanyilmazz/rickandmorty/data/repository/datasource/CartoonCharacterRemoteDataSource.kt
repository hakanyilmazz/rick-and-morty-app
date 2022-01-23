package com.hakanyilmazz.rickandmorty.data.repository.datasource

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacterList
import retrofit2.Response

interface CartoonCharacterRemoteDataSource {
    suspend fun getCartoonCharactersFromApi(page: Int = 1): Response<CartoonCharacterList>
}
package com.hakanyilmazz.rickandmorty.data.api

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getCartoonCharacters(@Query("page") page: Int = 1): Response<CartoonCharacterList>
}
package com.hakanyilmazz.rickandmorty.data.repository.datasourceimpl

import com.hakanyilmazz.rickandmorty.data.api.RickAndMortyService
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacterList
import com.hakanyilmazz.rickandmorty.data.repository.datasource.CartoonCharacterRemoteDataSource
import retrofit2.Response

class CartoonCharacterRemoteDataSourceImpl(
    private val rickAndMortyService: RickAndMortyService,
): CartoonCharacterRemoteDataSource {
    override suspend fun getCartoonCharactersFromApi(page: Int): Response<CartoonCharacterList> {
        return rickAndMortyService.getCartoonCharacters(page)
    }
}
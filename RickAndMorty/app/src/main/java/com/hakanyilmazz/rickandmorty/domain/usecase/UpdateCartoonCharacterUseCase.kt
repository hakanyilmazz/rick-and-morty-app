package com.hakanyilmazz.rickandmorty.domain.usecase

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.domain.repository.CartoonCharacterRepository

class UpdateCartoonCharacterUseCase(
    private val cartoonCharacterRepository: CartoonCharacterRepository
) {
    suspend fun execute(page: Int = 1): List<CartoonCharacter>? =
        cartoonCharacterRepository.updateCartoonCharacters(page)
}
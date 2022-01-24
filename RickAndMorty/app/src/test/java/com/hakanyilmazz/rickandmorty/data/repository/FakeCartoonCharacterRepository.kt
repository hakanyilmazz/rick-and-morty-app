package com.hakanyilmazz.rickandmorty.data.repository

import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.data.model.Origin
import com.hakanyilmazz.rickandmorty.domain.repository.CartoonCharacterRepository

class FakeCartoonCharacterRepository : CartoonCharacterRepository {
    private val cartoonCharacterList = mutableListOf<CartoonCharacter>()

    init {
        cartoonCharacterList.add(
            CartoonCharacter(
                "created1",
                "gender1",
                1,
                "image1",
                "name1",
                Origin("origin1"),
                "species1",
                "status1"
            )
        )

        cartoonCharacterList.add(
            CartoonCharacter(
                "created2",
                "gender2",
                2,
                "image2",
                "name2",
                Origin("origin2"),
                "species2",
                "status2"
            )
        )
    }

    override suspend fun getCartoonCharacters(page: Int): List<CartoonCharacter>? {
        return cartoonCharacterList
    }

    override suspend fun updateCartoonCharacters(page: Int): List<CartoonCharacter>? {
        cartoonCharacterList.clear()

        cartoonCharacterList.add(
            CartoonCharacter(
                "created3",
                "gender3",
                3,
                "image3",
                "name3",
                Origin("origin3"),
                "species3",
                "status3"
            )
        )

        cartoonCharacterList.add(
            CartoonCharacter(
                "created4",
                "gender4",
                4,
                "image4",
                "name4",
                Origin("origin4"),
                "species4",
                "status4"
            )
        )

        return cartoonCharacterList
    }
}
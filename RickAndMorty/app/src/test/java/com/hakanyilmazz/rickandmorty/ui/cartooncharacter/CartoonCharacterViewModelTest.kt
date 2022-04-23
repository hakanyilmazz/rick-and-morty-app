package com.hakanyilmazz.rickandmorty.ui.cartooncharacter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.data.model.Origin
import com.hakanyilmazz.rickandmorty.data.repository.FakeCartoonCharacterRepository
import com.hakanyilmazz.rickandmorty.domain.usecase.GetCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.domain.usecase.UpdateCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CartoonCharacterViewModelTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CartoonCharacterViewModel

    @Before
    fun setUp() {
        val fakeRepository = FakeCartoonCharacterRepository()
        val getCartoonCharacterUseCase = GetCartoonCharacterUseCase(fakeRepository)
        val updateCartoonCharacterUseCase = UpdateCartoonCharacterUseCase(fakeRepository)
        viewModel =
            CartoonCharacterViewModel(getCartoonCharacterUseCase, updateCartoonCharacterUseCase)
    }

    @Test
    fun getCartoonCharacters_returnsCurrentList() {
        val cartoonCharacterList = mutableListOf<CartoonCharacter>()

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

        val currentList =
            viewModel.getCartoonCharacters(InstrumentationRegistry.getInstrumentation().targetContext)
                .getOrAwaitValue()

        Truth.assertThat(currentList).isEqualTo(cartoonCharacterList)
    }

    @Test
    fun updateCartoonCharacters_returnsUpdatedList() {
        val cartoonCharacterList = mutableListOf<CartoonCharacter>()

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

        val updatedList =
            viewModel.updateCartoonCharacters(InstrumentationRegistry.getInstrumentation().targetContext)
                .getOrAwaitValue()

        Truth.assertThat(updatedList).isEqualTo(cartoonCharacterList)
    }
}
package com.hakanyilmazz.rickandmorty.ui.cartooncharacter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hakanyilmazz.rickandmorty.domain.usecase.GetCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.domain.usecase.UpdateCartoonCharacterUseCase

class CartoonCharacterViewModel(
    private val getCartoonCharacterUseCase: GetCartoonCharacterUseCase,
    private val updateCartoonCharacterUseCase: UpdateCartoonCharacterUseCase
) : ViewModel() {

    val page = MutableLiveData(0)
    val dataLoading = MutableLiveData(true)

    fun getCartoonCharacters() = liveData {
        dataLoading.value = true
        val list = getCartoonCharacterUseCase.execute(page.value!!)
        dataLoading.value = false
        emit(list)
    }

    fun updateCartoonCharacters() = liveData {
        dataLoading.value = true
        page.value = page.value!!.inc()
        val list = updateCartoonCharacterUseCase.execute(page.value!!)
        dataLoading.value = false
        emit(list)
    }

    fun getBack() = liveData {
        if (page.value!! > 1) {
            dataLoading.value = true
            page.value = page.value!!.dec()
            val list = updateCartoonCharacterUseCase.execute(page.value!!)
            dataLoading.value = false
            emit(list)
        }
    }

    fun currentPage(): Int {
        return page.value!!
    }
}
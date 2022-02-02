package com.hakanyilmazz.rickandmorty.ui.competition

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.domain.usecase.UpdateCartoonCharacterUseCase
import com.hakanyilmazz.rickandmorty.util.Network
import java.util.*

class CompetitionViewModel(
    private val updateCartoonCharacterUseCase: UpdateCartoonCharacterUseCase
) : ViewModel() {

    private val random = Random()
    private val characterList = MutableLiveData<List<CartoonCharacter>>()
    private var limit = MutableLiveData(0)
    val answer = MutableLiveData<CartoonCharacter?>(null)
    val score = MutableLiveData(0)

    fun getCartoonCharacters(context: Context) = liveData {
        if (Network.isNetworkAvailable(context)) {
            answer.value = null
            val randomPage = random.nextInt(42) + 1
            val list = updateCartoonCharacterUseCase.execute(randomPage)
            characterList.value = list!!
            emit(list)
        } else {
            emit(listOf())
        }
    }

    fun getRandomCharacter(context: Context): CartoonCharacter? {
        if (Network.isNetworkAvailable(context)) {
            if (limit.value == characterList.value?.size) {
                getCartoonCharacters(context)
                limit.value = 0
            }

            var result = characterList.value?.get(random.nextInt(characterList.value?.size!!))

            while (result?.name == answer.value?.name) {
                result = characterList.value?.get(random.nextInt(characterList.value?.size!!))
            }

            limit.value?.inc()
            return result
        } else {
            return null
        }
    }

    fun setAnswer(context: Context): CartoonCharacter? {
        answer.value = getRandomCharacter(context)
        return answer.value
    }

    fun checkAnswer(name: String): Boolean {
        return if (name == answer.value?.name) {
            score.value = score.value!!.plus(1)
            true
        } else {
            false
        }
    }
}
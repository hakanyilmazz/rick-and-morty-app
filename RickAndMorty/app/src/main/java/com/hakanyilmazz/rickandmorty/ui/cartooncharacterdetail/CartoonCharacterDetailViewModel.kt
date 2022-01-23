package com.hakanyilmazz.rickandmorty.ui.cartooncharacterdetail

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class CartoonCharacterDetailViewModel : ViewModel() {

    private val dateFormatForConverting = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    private val dateFormatForDisplaying = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    fun getFormattedDate(dateForConverting: String): String {
        val date = dateFormatForConverting.parse(dateForConverting)
        return dateFormatForDisplaying.format(date!!)
    }
}
package com.hakanyilmazz.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hakanyilmazz.rickandmorty.R
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.databinding.CartoonCharacterListRowBinding

class CartoonCharacterAdapter(private val onClick: (cartoonCharacter: CartoonCharacter) -> Unit) :
    RecyclerView.Adapter<CartoonCharacterAdapter.CartoonCharacterViewHolder>() {

    private val cartoonCharacterList = ArrayList<CartoonCharacter>()

    class CartoonCharacterViewHolder(private val binding: CartoonCharacterListRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            cartoonCharacter: CartoonCharacter,
            onClick: (cartoonCharacter: CartoonCharacter) -> Unit
        ) {
            binding.cartoonCharacterItem = cartoonCharacter
            binding.itemCardView.setOnClickListener {
                onClick(cartoonCharacter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartoonCharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CartoonCharacterListRowBinding>(
            layoutInflater,
            R.layout.cartoon_character_list_row,
            parent,
            false
        )

        return CartoonCharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartoonCharacterViewHolder, position: Int) {
        holder.bind(cartoonCharacterList[position], onClick)
    }

    override fun getItemCount(): Int {
        return cartoonCharacterList.size
    }

    fun setList(cartoonCharacterList: List<CartoonCharacter>) {
        this.cartoonCharacterList.clear()
        this.cartoonCharacterList.addAll(cartoonCharacterList)
        notifyDataSetChanged()
    }
}
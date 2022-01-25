package com.hakanyilmazz.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hakanyilmazz.rickandmorty.R
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.databinding.CartoonCharacterListRowBinding

class CartoonCharacterAdapter(private val onClick: (cartoonCharacter: CartoonCharacter) -> Unit) :
    RecyclerView.Adapter<CartoonCharacterAdapter.CartoonCharacterViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<CartoonCharacter>() {
        override fun areItemsTheSame(
            oldItem: CartoonCharacter,
            newItem: CartoonCharacter
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CartoonCharacter,
            newItem: CartoonCharacter
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val listDiffer = AsyncListDiffer(this, diffUtil)
    private var cartoonCharacterList: List<CartoonCharacter>
        get() = listDiffer.currentList
        set(value) = listDiffer.submitList(value)

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
        this.cartoonCharacterList = cartoonCharacterList
    }
}
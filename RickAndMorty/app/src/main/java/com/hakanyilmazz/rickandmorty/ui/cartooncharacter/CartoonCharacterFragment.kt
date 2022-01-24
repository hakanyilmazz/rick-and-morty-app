package com.hakanyilmazz.rickandmorty.ui.cartooncharacter

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanyilmazz.rickandmorty.R
import com.hakanyilmazz.rickandmorty.adapter.CartoonCharacterAdapter
import com.hakanyilmazz.rickandmorty.data.model.CartoonCharacter
import com.hakanyilmazz.rickandmorty.databinding.FragmentCartoonCharacterBinding
import com.hakanyilmazz.rickandmorty.ui.base.BaseFragment
import javax.inject.Inject

class CartoonCharacterFragment :
    BaseFragment<FragmentCartoonCharacterBinding, CartoonCharacterViewModel>(
        R.layout.fragment_cartoon_character
    ) {

    @Inject
    lateinit var factory: CartoonCharacterViewModelFactory

    private lateinit var adapter: CartoonCharacterAdapter
    private var isFirstOpening = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInjector().createCartoonCharacterSubcomponent().inject(this)

        initViewModel(
            ViewModelProvider(viewModelStore, factory)[CartoonCharacterViewModel::class.java]
        )
        binding?.viewModel = viewModel

        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        binding?.floatingActionButtonNext?.setOnClickListener {
            displayCartoonCharacters(true)
        }

        binding?.floatingActionButtonBack?.setOnClickListener {
            displayCartoonCharactersBack()
        }

        viewModel?.let {
            it.page.observe(viewLifecycleOwner) { pageValue ->
                if (pageValue > 42) {
                    it.page.value = 42
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.update_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ac_update -> {
                displayCartoonCharacters(false)
            }
            R.id.ac_competition -> {
                val action =
                    CartoonCharacterFragmentDirections.actionCartoonCharacterFragmentToCompetitionFragment()
                Navigation.findNavController(requireView()).navigate(action)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView() {
        binding?.let {
            it.recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = CartoonCharacterAdapter { itemCartoonCharacter ->
                val action =
                    CartoonCharacterFragmentDirections.actionCartoonCharacterFragmentToCartoonCharacterDetailFragment(
                        itemCartoonCharacter
                    )
                Navigation.findNavController(requireView()).navigate(action)
            }

            it.recyclerView.adapter = adapter
            displayCartoonCharacters(isFirstOpening)
            isFirstOpening = false
        }
    }

    private fun displayCartoonCharacters(next: Boolean) {
        viewModel?.let {
            val responseLiveData = if (next) {
                it.updateCartoonCharacters()
            } else {
                it.getCartoonCharacters()
            }

            observeData(responseLiveData)
        }
    }

    private fun displayCartoonCharactersBack() {
        viewModel?.let {
            val responseLiveData = it.getBack()
            observeData(responseLiveData)
        }
    }

    private fun observeData(responseLiveData: LiveData<List<CartoonCharacter>?>) {
        responseLiveData.observe(viewLifecycleOwner) { listOfCartoonCharacters ->
            if (!listOfCartoonCharacters.isNullOrEmpty()) {
                (requireActivity() as AppCompatActivity).supportActionBar?.title =
                    "Characters ${viewModel?.currentPage()}"

                adapter.setList(listOfCartoonCharacters)
                binding?.recyclerView?.layoutManager?.scrollToPosition(0)
            } else {
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}
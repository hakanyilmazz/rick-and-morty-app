package com.hakanyilmazz.rickandmorty.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.hakanyilmazz.rickandmorty.di.Injector

abstract class BaseFragment<B : ViewDataBinding, V : ViewModel>(
    @LayoutRes private val layoutIdRes: Int
) : Fragment() {

    protected var binding: B? = null
    protected var viewModel: V? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<B>(
            inflater,
            layoutIdRes,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun initViewModel(viewModel: V) {
        this.viewModel = viewModel
    }

    fun getInjector(): Injector {
        return (activity?.application as Injector)
    }
}
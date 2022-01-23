package com.hakanyilmazz.rickandmorty.ui.competition

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.hakanyilmazz.rickandmorty.R
import com.hakanyilmazz.rickandmorty.databinding.FragmentCompetitionBinding
import com.hakanyilmazz.rickandmorty.ui.base.BaseFragment
import javax.inject.Inject

class CompetitionFragment :
    BaseFragment<FragmentCompetitionBinding, CompetitionViewModel>(R.layout.fragment_competition) {

    @Inject
    lateinit var factory: CompetitionViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInjector().createCompetitionSubcomponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel(
            ViewModelProvider(viewModelStore, factory)[CompetitionViewModel::class.java]
        )
    }
}
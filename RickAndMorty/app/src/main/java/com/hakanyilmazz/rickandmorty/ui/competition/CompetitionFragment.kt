package com.hakanyilmazz.rickandmorty.ui.competition

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.hakanyilmazz.rickandmorty.R
import com.hakanyilmazz.rickandmorty.databinding.FragmentCompetitionBinding
import com.hakanyilmazz.rickandmorty.ui.base.BaseFragment
import com.hakanyilmazz.rickandmorty.util.Network
import java.util.*
import javax.inject.Inject


class CompetitionFragment :
    BaseFragment<FragmentCompetitionBinding, CompetitionViewModel>(R.layout.fragment_competition) {

    @Inject
    lateinit var factory: CompetitionViewModelFactory
    private lateinit var buttonList: ArrayList<MaterialButton>
    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInjector().createCompetitionSubcomponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel(
            ViewModelProvider(viewModelStore, factory)[CompetitionViewModel::class.java]
        )

        if (Network.isNetworkAvailable(requireContext())) {
            binding?.let {
                it.viewModel = this.viewModel

                buttonList = arrayListOf(
                    it.optionA,
                    it.optionB,
                    it.optionC
                )

                setButtonColorsDefault()

                it.checkButton.setOnClickListener {
                    viewModel?.getCartoonCharacters(requireContext())?.observe(viewLifecycleOwner) {
                        setButtonColorsDefault()
                        setButtonTexts()
                        showButtons()
                    }
                }

                viewModel?.getCartoonCharacters(requireContext())?.observe(viewLifecycleOwner) {
                    showButtons()
                    setButtonTexts()
                }
            }
        } else {
            binding?.let {
                it.viewModel = this.viewModel

                it.scoreText.text = "0"
                it.checkButton.isEnabled = false
                it.optionA.isEnabled = false
                it.optionB.isEnabled = false
                it.optionC.isEnabled = false
            }
        }
    }

    private fun setButtonTexts() {
        for (button in buttonList) {
            button.text = ""
            button.setOnClickListener {
                val buttonText = (it as MaterialButton).text.toString()
                val isTrueAnswer = viewModel?.checkAnswer(buttonText)
                hideButtons()

                if (isTrueAnswer == true) {
                    button.setBackgroundColor(Color.GREEN)
                } else {
                    button.setBackgroundColor(Color.RED)
                }
            }
        }

        val randomIndex = random.nextInt(buttonList.size)
        buttonList[randomIndex].text = viewModel?.setAnswer(requireContext())?.name

        for (i in 0 until buttonList.size) {
            if (i != randomIndex) {
                buttonList[i].text = viewModel?.getRandomCharacter(requireContext())?.name
            }
        }
    }

    private fun hideButtons() {
        for (button in buttonList) {
            button.isEnabled = false
        }
    }

    private fun showButtons() {
        for (button in buttonList) {
            button.isEnabled = true
        }
    }

    private fun setButtonColorsDefault() {
        for (button in buttonList) {
            button.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.primary_variant_color
                )
            )
        }
    }
}
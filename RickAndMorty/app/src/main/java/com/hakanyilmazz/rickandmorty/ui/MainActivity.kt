package com.hakanyilmazz.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.hakanyilmazz.rickandmorty.R
import com.hakanyilmazz.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initToolbarNavigation()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun initToolbarNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.cartoonCharacterFragment,
                R.id.cartoonCharacterDetailFragment,
                R.id.competitionFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.cartoonCharacterFragment -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }
                R.id.cartoonCharacterDetailFragment -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
                R.id.competitionFragment -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }
        }
    }
}
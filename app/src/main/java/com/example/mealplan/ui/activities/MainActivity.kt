package com.example.mealplan.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mealplan.databinding.ActivityMainBinding
import com.example.mealplan.listeners.ItemAddListeners
import com.example.mealplan.ui.fragment.HomeFragment
import com.example.mealplan.ui.fragment.MenuFragment
import com.example.mealplan.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemAddListeners {

    var itemAddListeners: ItemAddListeners = this
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
        setContentView(binding.root)

        mainViewModel.settingMealList()
        mainViewModel.settingMenuList()

        supportFragmentManager.beginTransaction()
            .replace(binding.rootContainer.id, HomeFragment(itemAddListeners))
            .commit()
    }

    override fun addItem(positionChild: Int, positionParent: Int) {
        supportFragmentManager.beginTransaction()
            .replace(binding.rootContainer.id, MenuFragment(positionChild, positionParent))
            .addToBackStack(null)
            .commit()
    }


}
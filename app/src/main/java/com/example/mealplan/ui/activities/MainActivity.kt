package com.example.mealplan.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplan.databinding.ActivityMainBinding
import com.example.mealplan.model.mealPlan
import com.example.mealplan.ui.adapter.MealTimeAdapter
import com.example.mealplan.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mealTimeAdapter: MealTimeAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.settingMealList()

        mainViewModel.mealPlanList.observe(this) {
            initMainView(it)
        }
    }

    private fun initMainView(mealList: ArrayList<mealPlan>) {

        mealTimeAdapter = MealTimeAdapter(mealList,this)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = mealTimeAdapter
        binding.rvMain.setHasFixedSize(true)
    }
}
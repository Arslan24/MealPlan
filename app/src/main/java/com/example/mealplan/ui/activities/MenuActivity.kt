package com.example.mealplan.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplan.databinding.ActiivityMenuBinding
import com.example.mealplan.ui.adapter.MenuAdapter
import com.example.mealplan.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActiivityMenuBinding
    lateinit var menuAdapter: MenuAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pos =intent.getStringExtra("menuTime")

        mainViewModel.settingMenuList()

        mainViewModel.menuList.observe(this) {
            initMainView(it)
        }

        binding.btnSaveM.setOnClickListener{
           var menu = menuAdapter.saveRecipe()
            if(menu.isNotEmpty())
            {

            }
        }
    }


    private fun initMainView(menuList: ArrayList<String>) {

        menuAdapter = MenuAdapter(menuList)
        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        binding.rvMenu.adapter = menuAdapter
        binding.rvMenu.setHasFixedSize(true)
    }
}
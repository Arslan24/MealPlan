package com.example.mealplan.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplan.R
import com.example.mealplan.databinding.FragmentMenuBinding
import com.example.mealplan.model.mealPlan
import com.example.mealplan.ui.adapter.MenuAdapter
import com.example.mealplan.viewModel.MainViewModel


class MenuFragment(var positionChild: Int, var positionParent: Int) : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    lateinit var menuAdapter: MenuAdapter
    lateinit var mainList: ArrayList<mealPlan>
    lateinit var menuList: ArrayList<String>
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view: View = binding.root
        onBind()
        return view
    }

    fun onBind() {

        mainViewModel.menuList.observe(viewLifecycleOwner) {
            menuList = it
            initMainView(it)
        }

        mainViewModel.mealPlanList.observe(viewLifecycleOwner) {
            mainList = it
        }

        binding.btnSaveM.setOnClickListener {
            var menu = menuAdapter.saveRecipe()
            if (menu.isNotEmpty()) {
                if (mainList.isNotEmpty())
                    mainList[positionParent].mealTimes[positionChild].mealMenu = menu.toString()
                mainViewModel.mealPlanList.value = mainList
            }
            activity?.onBackPressed()
        }

        binding.btnAddM.setOnClickListener {
            showingDialog()
        }
    }

    private fun showingDialog() {

        val alert: AlertDialog.Builder = AlertDialog.Builder(context)
        alert.setTitle(context?.getString(R.string.label_title))
        alert.setMessage(context?.getString(R.string.label_message))
        val input = EditText(context)
        alert.setView(input)
        alert.setPositiveButton(
            context?.getString(R.string.label_ok)
        ) { dialog, whichButton ->
            val value: String = input.text.toString()
            if (value.isNotEmpty()) {
                menuList.add(value)
                mainViewModel.menuList.value = menuList
            }
        }

        alert.setNegativeButton(
            context?.getString(R.string.label_cancel)
        ) { dialog, whichButton ->
        }

        alert.show()
    }


    private fun initMainView(menuList: ArrayList<String>) {

        menuAdapter = MenuAdapter(menuList)
        binding.rvMenu.layoutManager = LinearLayoutManager(context)
        binding.rvMenu.adapter = menuAdapter
        binding.rvMenu.setHasFixedSize(true)
    }
}
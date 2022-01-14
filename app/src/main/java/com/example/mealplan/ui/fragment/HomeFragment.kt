package com.example.mealplan.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealplan.databinding.FragmentMainBinding
import com.example.mealplan.listeners.ItemAddListeners
import com.example.mealplan.model.mealPlan
import com.example.mealplan.ui.adapter.MealTimeAdapter
import com.example.mealplan.viewModel.MainViewModel

class HomeFragment(var itemAddListeners: ItemAddListeners) : Fragment() {

    private lateinit var binding: FragmentMainBinding
    lateinit var mealTimeAdapter: MealTimeAdapter

    lateinit var mainList: ArrayList<mealPlan>
    private val mainViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val view: View = binding.root
        onBind()
        return view
    }

    private fun onBind() {
        observerMainList()
    }

    private fun observerMainList() {

        mainViewModel.mealPlanList.observe(viewLifecycleOwner) {
            mainList = it
            if (binding.rvMain.adapter == null)
                initMainView(it)
        }
    }

    private fun initMainView(mealList: ArrayList<mealPlan>) {

        mealTimeAdapter = MealTimeAdapter(mealList, requireContext(), itemAddListeners)
        binding.rvMain.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMain.adapter = mealTimeAdapter
        binding.rvMain.setHasFixedSize(true)
    }
}
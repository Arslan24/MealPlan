package com.example.mealplan.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealplan.model.mealPlan
import com.example.mealplan.model.mealTime
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    // List
    var mealPlanList = MutableLiveData<ArrayList<mealPlan>>()

    fun settingMealList() {
        var mealList = ArrayList<mealPlan>()
        for (i in 1..5) {
            mealList.add(mealPlan("Day $i", setMealDay()))
        }
        mealPlanList.postValue(mealList)
    }

    private fun setMealDay(): ArrayList<mealTime> {

        var mealTimeList = ArrayList<mealTime>()

        var mealIItem = mealTime("BreakFast", "-----")
        var mealIItem1 = mealTime("Lunch", "-----")
        var mealIItem2 = mealTime("Diner", "-----")

        mealTimeList.add(mealIItem)
        mealTimeList.add(mealIItem1)
        mealTimeList.add(mealIItem2)

        return mealTimeList
    }

}
package com.example.mealplan.viewModel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealplan.R
import com.example.mealplan.model.mealPlan
import com.example.mealplan.model.mealTime
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(@ApplicationContext var context: Context) : ViewModel() {

    var mealPlanList = MutableLiveData<ArrayList<mealPlan>>()
    var menuList = MutableLiveData<ArrayList<String>>()

    fun settingMealList() {
        var mealList = ArrayList<mealPlan>()
        for (i in 1..5) {
            mealList.add(mealPlan("Day $i", setMealDay(i - 1)))
        }
        mealPlanList.postValue(mealList)
    }

    private fun setMealDay(pos: Int): ArrayList<mealTime> {

        var mealTimeList = ArrayList<mealTime>()

        var mealIItem = mealTime(context.getString(R.string.label_break_fast), pos, "-----")
        var mealIItem1 = mealTime(context.getString(R.string.label_lunch), pos, "-----")
        var mealIItem2 = mealTime(context.getString(R.string.label_dinner), pos, "-----")

        mealTimeList.add(mealIItem)
        mealTimeList.add(mealIItem1)
        mealTimeList.add(mealIItem2)

        return mealTimeList
    }

    @SuppressLint("StringFormatMatches")
    fun settingMenuList() {
        var menu = ArrayList<String>()
        for (i in 1..7) {
            menu.add(context.getString(R.string.label_menu_item, i))
        }
        menuList.postValue(menu)
    }
}
package com.example.mealplan.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplan.R
import com.example.mealplan.listeners.ItemAddListeners
import com.example.mealplan.model.mealPlan
import com.example.mealplan.ui.activities.MainActivity

class MealTimeAdapter(
    var mealList: ArrayList<mealPlan>,
    var context: MainActivity,
    var itemAddListeners: ItemAddListeners
) :
    RecyclerView.Adapter<MealTimeAdapter.MealTimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealTimeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_parent_item, parent, false)
        return MealTimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealTimeViewHolder, position: Int) {
        val mealItem = mealList[position]
        holder.tvDayName.text = mealItem.dayName

        var mealTimeDetailAdapter = MealTimeDetailAdapter(mealItem.mealTimes,itemAddListeners)
        holder.rvParent.layoutManager = LinearLayoutManager(context)
        holder.rvParent.adapter = mealTimeDetailAdapter
        holder.rvParent.setHasFixedSize(true)

    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    class MealTimeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvDayName: AppCompatTextView = view.findViewById(R.id.tvDayName)
        val rvParent: RecyclerView = view.findViewById(R.id.rvParent)

    }

}
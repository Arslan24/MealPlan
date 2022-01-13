package com.example.mealplan.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplan.R
import com.example.mealplan.model.mealTime

class MealTimeDetailAdapter(var mealTime: ArrayList<mealTime>) :
    RecyclerView.Adapter<MealTimeDetailAdapter.MealTimeDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealTimeDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_child_item, parent, false)
        return MealTimeDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealTimeDetailViewHolder, position: Int) {
        val mealItem = mealTime[position]
        holder.tvMealTime.text = mealItem.mealTimeName
        holder.tvMeal.text = mealItem.mealMenu

    }

    override fun getItemCount(): Int {
        return mealTime.size
    }

    class MealTimeDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMealTime: AppCompatTextView = view.findViewById(R.id.tvMealTime)
        val tvMeal: AppCompatTextView = view.findViewById(R.id.tvMeal)

    }

}
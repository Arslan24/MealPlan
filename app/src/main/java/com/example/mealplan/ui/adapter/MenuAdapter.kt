package com.example.mealplan.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mealplan.R

class MenuAdapter(var menuList: ArrayList<String>) :
    RecyclerView.Adapter<MenuAdapter.MenuItemViewHolder>() {

    var menuItem = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_menu, parent, false)
        return MenuItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        val menu = menuList[position]
        holder.tvName.text = menu

        holder.check.setOnClickListener {
            if (holder.check.isSelected) {
                holder.check.isSelected = false
                addOrRemoveItem(false, position)
            } else {
                holder.check.isSelected = true
                addOrRemoveItem(true, position)

            }
        }

    }

    private fun addOrRemoveItem(action: Boolean, position: Int) {
        if (action)
            menuItem.add(menuList[position])
        else {
            menuList.map {
                if (it == menuList[position])
                    menuItem.remove(it)
            }
        }
    }


    fun saveRecipe(): ArrayList<String> {
        return menuItem
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class MenuItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val check: CheckBox = view.findViewById(R.id.check)
        val tvName: AppCompatTextView = view.findViewById(R.id.tvName)
    }

}
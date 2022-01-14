package com.example.mealplan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class mealPlan(
    var dayName: String,
    var mealTimes: ArrayList<mealTime>
) : Parcelable



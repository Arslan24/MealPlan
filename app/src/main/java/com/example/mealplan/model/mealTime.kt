package com.example.mealplan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class mealTime(
    var mealTimeName: String,
    var parentPos: Int,
    var mealMenu: String
):Parcelable

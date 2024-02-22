package com.example.assignmenttwo

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Student(
    val rollNo: String="",
    val name: String="",
    val password: String="",
    val className: String="",
    val gender: String="",
    val Dob: String="",
    val phone: String="",
    val address: String=""
)

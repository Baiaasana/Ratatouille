package com.example.designsystem.utils

import android.content.Context
import com.example.designsystem.R

enum class Gender(val value: Int, val toServer: String) {
    Female(value = R.string.female, toServer = "Female"),
    Male(value = R.string.male, toServer = "Male"),
    OTHER(value = R.string.other, toServer = "Other"),
}

fun getToServerFromResourceGender(context: Context, resourceString: String): String {
    val matchingEnum = Gender.values().find { context.getString(it.value) == resourceString }
    return matchingEnum?.toServer.toString()
}

fun getValueFromToServerGender(toServer: String): Int? {
    val matchingEnum = Gender.values().find { it.toServer == toServer }
    return matchingEnum?.value
}

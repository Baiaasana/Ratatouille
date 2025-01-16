package com.example.designsystem.utils

import android.content.Context
import com.example.designsystem.R

enum class Condition(val value: Int, val toServer: String) {
    NEW(value = R.string.new_word, toServer = "New"),
    USED_LIKE_NEW(value = R.string.used_like_new, toServer = "Used - Like New"),
    USED_VERY_GOOD(value = R.string.used_very_good, toServer = "Used - Very Good"),
    USED_GOOD(value = R.string.used_good, toServer = "Used - Good"),
    USED_ACCEPTABLE(value = R.string.used_acceptable, toServer = "Used - Acceptable"),
}

fun getToServerFromResourceCondition(context: Context, resourceString: String): String {
    val matchingEnum = Condition.values().find { context.getString(it.value) == resourceString }
    return matchingEnum?.toServer.toString()
}

fun getValueFromToServerCondition(toServer: String): Int? {
    val matchingEnum = Condition.values().find { it.toServer == toServer }
    return matchingEnum?.value
}
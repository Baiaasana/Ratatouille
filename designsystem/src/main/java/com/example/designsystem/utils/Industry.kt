package com.example.designsystem.utils

import android.content.Context
import com.example.designsystem.R

enum class Industry(val value: Int, val toServer: String) {
    ELECTRONICS(value = R.string.Electronics, toServer = "Electronics"),
    FASHION(value = R.string.Fashion, toServer = "Fashion"),
    HOME_GARDEN(value = R.string.Home, toServer = "Home & Garden"),
    TOOLS_EQUIPMENT(value = R.string.Tools, toServer = "Tools & Equipment"),
    CARS(value = R.string.Cars, toServer = "Cars"),
    CAR_PARTS(value = R.string.Car_Parts, toServer = "Car Parts & Accessories"),
    COSMETICS(value = R.string.Cosmetics, toServer = "Cosmetics"),
    COLLECTIBLES_ART(value = R.string.Collectibles, toServer = "Collectibles & Art"),
    SPORTING_GOODS(value = R.string.Sporting, toServer = "Sporting Goods"),
    TOYS_HOBBIES(value = R.string.Toys, toServer = "Toys & Hobbies"),
    MUSICAL_INSTRUMENTS(value = R.string.Musical, toServer = "Musical Instruments & Gear"),
    BUSINESS_INDUSTRIAL(value = R.string.Business, toServer = "Business & Industrial"),
    BOOKS_MEDIA(value = R.string.Books, toServer = "Books & Movies & Music"),
    HEALTH_BEAUTY(value = R.string.Health, toServer = "Health & Beauty"),
    JEWELRY_WATCHES(value = R.string.Jewelry, toServer = "Jewelry & Watches"),
    REAL_ESTATE(value = R.string.Real, toServer = "Real Estate"),
    TRAVEL(value = R.string.Travel, toServer = "Travel"),
    OTHER(value = R.string.Other, toServer = "Other"),
}

fun getToServerFromResourceIndustry(context: Context, resourceString: String): String {
    val matchingEnum = Industry.values().find { context.getString(it.value) == resourceString }
    return matchingEnum?.toServer.toString()
}

fun getValueFromToServerIndustry(toServer: String): Int? {
    val matchingEnum = Industry.values().find { it.toServer == toServer }
    return matchingEnum?.value
}
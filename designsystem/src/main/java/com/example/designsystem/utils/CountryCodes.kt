package com.example.designsystem.utils

import java.util.Locale

fun getCountriesForCode(): Map<String, String> {
    val isoCountryCodes: Array<String> = Locale.getISOCountries()
    val countryNameToCodeMap: MutableMap<String, String> = mutableMapOf()

    for (countryCode in isoCountryCodes) {
        val locale = Locale("", countryCode)
        val countryName: String = locale.displayCountry
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
        val flag = String(Character.toChars(firstChar)) + String(Character.toChars(secondChar))
        countryNameToCodeMap["$countryName $flag"] = countryCode
    }
    return countryNameToCodeMap
}

fun getCountryCodeByName(countryName: String, countriesMap: Map<String, String>): String? {
    return countriesMap[countryName]
}
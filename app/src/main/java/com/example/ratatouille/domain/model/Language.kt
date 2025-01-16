package com.example.ratatouille.domain.model

enum class Language(val configName: String) {
    GEO("ka"),
    ENGLISH("en");

    companion object {
        fun getOppositeLanguage(configName: String): Language? {
            return when (configName) {
                GEO.configName -> ENGLISH
                ENGLISH.configName -> GEO
                else -> GEO
            }
        }
    }
}

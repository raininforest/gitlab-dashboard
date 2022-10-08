package com.github.raininforest.core.service

interface PreferenceService {
    fun loadStringFromPreferences(key: String): String
    fun saveToPreferences(map: Map<String, String>)
}

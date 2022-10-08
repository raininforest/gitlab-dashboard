package com.github.raininforest.gitlabdashboard.service

import android.content.Context
import android.content.SharedPreferences
import com.github.raininforest.core.service.PreferenceService
import javax.inject.Inject

class PreferenceServiceImpl @Inject constructor(private val context: Context) : PreferenceService {
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(MAIN_PREFS, Context.MODE_PRIVATE)
    }

    override fun loadStringFromPreferences(key: String): String =
        prefs.getString(key, "").orEmpty()

    override fun saveToPreferences(map: Map<String, String>) {
        val editor = prefs.edit()
        map.forEach { editor.putString(it.key, it.value) }
        editor.apply()
    }

    companion object {
        private const val MAIN_PREFS = "main_shared_prefs"
    }
}

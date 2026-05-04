package com.me.littlelemoncapstone

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object PreferencesManager {
    private const val PREFS_NAME = "LITTLE_LEMON"

    // Key Names
    private const val KEY_FIRST_NAME = "PREF_FIRST_NAME"
    private const val KEY_LAST_NAME = "PREF_LAST_NAME"
    private const val KEY_EMAIL = "PREF_EMAIL"
    private const val KEY_IS_LOGGED_IN = "PREF_IS_LOGGED_IN"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun setUserData(context: Context, firstName: String, lastName: String, email: String) {
        getPrefs(context).edit {
            putString(KEY_FIRST_NAME, firstName)
            putString(KEY_LAST_NAME, lastName)
            putString(KEY_EMAIL, email)

            putBoolean(KEY_IS_LOGGED_IN, true)
        }
    }

    fun removeUserData(context: Context) {
        getPrefs(context).edit {
            remove(KEY_FIRST_NAME)
            remove(KEY_LAST_NAME)
            remove(KEY_EMAIL)

            remove(KEY_IS_LOGGED_IN)
        }
    }

    fun getUserData(context: Context): UserData {
        val userData = UserData(getPrefs(context).getString(KEY_FIRST_NAME, null),
            getPrefs(context).getString(KEY_LAST_NAME, null),
            getPrefs(context).getString(KEY_EMAIL, null))
        return userData
    }

    fun isUserLoggedIn(context: Context): Boolean {
        return getPrefs(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }
}
package com.amzuni.fontstyle.util

import android.content.Context
import android.content.SharedPreferences

class AppSetting(context: Context) {
    private var sharedPreference: SharedPreferences
    init {
        sharedPreference =  context.getSharedPreferences(Constants.PREFERENCE_APP, Context.MODE_PRIVATE)
    }

    fun setNotification(bool: Boolean){
        var editor = sharedPreference.edit()

        when(bool){
            true -> editor.putBoolean(Constants.NOTIFICATION_ENABLED, true)
            else -> editor.putBoolean(Constants.NOTIFICATION_ENABLED, false)
        }

        editor.commit()
    }

    fun getNotification() : Boolean{
        return sharedPreference.getBoolean(Constants.NOTIFICATION_ENABLED, true)
    }
}
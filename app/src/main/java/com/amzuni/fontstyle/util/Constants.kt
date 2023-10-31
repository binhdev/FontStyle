package com.amzuni.fontstyle.util

class Constants {
    companion object {

        const val FAVOURITE : Int = 1
        const val NOT_FAVOURITE : Int = 0
        const val VIEWED : Int = 1
        const val NOT_VIEWED : Int = 1

        const val ADS_INTERSTITIAL = "ca-app-pub-1026571410838165/3015517967"

        var COUNT_INTERSTITIAL = 0
        var REQUEST_INTERSTITIAL = 3

        var BASE_URL = "https://coolstyles.org/api/"

        /**
         * Notification
         */
        const val CHANEL_ID = "best_quote"
        const val NOTIFICATION_ID = 123
        const val INTENT_ACTION = "com.fpmi.apps.bestsaying.ALARM"
        const val MINUS_NOTIFICATION : Int = 1
        const val HOUR_NOTIFICATION : Int = 8

        /**
         * Settings
         */
        const val NOTIFICATION_ENABLED = "notification_enabled"
        const val PREFERENCE_APP = "preference_app"

    }
}
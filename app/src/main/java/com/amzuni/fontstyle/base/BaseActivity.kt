package com.amzuni.fontstyle.base

import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.util.Constants
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.ump.ConsentForm
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
import com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import java.util.*

abstract class BaseActivity : AppCompatActivity(){
    private lateinit var consentInformation: ConsentInformation
    private lateinit var consentForm: ConsentForm
    var titleBar : TextView? = null
    var menuBack : RelativeLayout? = null
    var menuRefresh : RelativeLayout? = null
    lateinit var mAdView : AdView
    var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "BaseActivity"

    private val RECORD_AUDIO_REQUEST_CODE = 1

    protected fun getConsentInfo(){
        // Set tag for under age of consent. false means users are not under
        // age.
//        val debugSettings = ConsentDebugSettings.Builder(this)
//            .setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
//            .addTestDeviceHashedId("A16D69E054D10347A4E343EB7B647E37")
//            .build()
//
//        val params = ConsentRequestParameters
//            .Builder()
//            .setConsentDebugSettings(debugSettings)
//            .build()

        val params = ConsentRequestParameters
            .Builder()
            .setTagForUnderAgeOfConsent(false)
            .build()
        consentInformation = UserMessagingPlatform.getConsentInformation(this)
        consentInformation.requestConsentInfoUpdate(
            this,
            params,
            OnConsentInfoUpdateSuccessListener {
                // The consent information state was updated.
                // You are now ready to check if a form is available.
                loadForm()
            },
            OnConsentInfoUpdateFailureListener {
                // Handle the error.
                Log.i("consent", it.toString())
            })

    }
    private fun loadForm() {
        // Loads a consent form. Must be called on the main thread.
        UserMessagingPlatform.loadConsentForm(
            this,
            {

                this.consentForm = it
                if (consentInformation.consentStatus == ConsentInformation.ConsentStatus.REQUIRED) {
                    consentForm.show(
                        this
                    ) {
                        if (consentInformation.consentStatus == ConsentInformation.ConsentStatus.OBTAINED) {
                            // App can start requesting ads.

                        }
                        loadForm()
                    }
                }
            },
            {
                // Handle the error.
                Log.i("consent", it.message)
            }
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == RECORD_AUDIO_REQUEST_CODE && grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) Toast.makeText(
                this,
                "Permission Granted",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    abstract fun initGUI();

    fun loadAdsBanner() {
        MobileAds.initialize(this) {}

        val testDeviceIds = Arrays.asList("A16D69E054D10347A4E343EB7B647E37")
        val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                mAdView.visibility = View.VISIBLE
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }
    }

    fun loadInterstitialAd(){
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,Constants.ADS_INTERSTITIAL, adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
    }

    fun startInterstitialAd(intent: Intent){
        Constants.COUNT_INTERSTITIAL++
        if (Constants.COUNT_INTERSTITIAL % Constants.REQUEST_INTERSTITIAL == 0){
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
                mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
                    override fun onAdClicked() {
                        // Called when a click is recorded for an ad.
                        Log.d(TAG, "Ad was clicked.")
                    }

                    override fun onAdDismissedFullScreenContent() {
                        // Called when ad is dismissed.
                        Log.d(TAG, "Ad dismissed fullscreen content.")
                        mInterstitialAd = null
                        startActivity(intent)
                    }

                    override fun onAdImpression() {
                        // Called when an impression is recorded for an ad.
                        Log.d(TAG, "Ad recorded an impression.")
                    }

                    override fun onAdShowedFullScreenContent() {
                        // Called when ad is shown.
                        Log.d(TAG, "Ad showed fullscreen content.")
                    }
                }
            } else {
                startActivity(intent)
            }
        }else{
            startActivity(intent)
        }
    }
}
package com.amzuni.fontstyle.base

import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.View
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.util.Constants
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

abstract class BaseFragment : Fragment() {
    lateinit var mAdView : AdView
    var mInterstitialAd: InterstitialAd? = null
    private val TAG = "Ads"
    fun loadAdsBanner(root: View) {
        context?.let {
            MobileAds.initialize(it) {}
            val testDeviceIds = listOf("A16D69E054D10347A4E343EB7B647E37")
            val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
            MobileAds.setRequestConfiguration(configuration)

            mAdView = root.findViewById(R.id.adView)
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
    }

    fun loadInterstitialAd(){
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(requireContext(),
            Constants.ADS_INTERSTITIAL, adRequest, object : InterstitialAdLoadCallback() {
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
                mInterstitialAd?.show(requireActivity())
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
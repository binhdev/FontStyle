package com.amzuni.fontstyle.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.base.BaseFragment

class SettingFragment : BaseFragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_setting, container, false)

        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        loadAdsBanner()
    }

}
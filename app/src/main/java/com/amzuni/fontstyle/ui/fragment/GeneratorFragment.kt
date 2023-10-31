package com.amzuni.fontstyle.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amzuni.fontstyle.R
import com.amzuni.fontstyle.base.BaseFragment
import com.amzuni.fontstyle.ui.constract.GeneratorFragmentConstract


class GeneratorFragment : BaseFragment(), GeneratorFragmentConstract.IView {
    private lateinit var mPresenter : GeneratorFragmentConstract.IPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_generator, container, false)
        loadAdsBanner(viewRoot)

        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        loadAdsBanner()
    }

}
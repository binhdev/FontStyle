package com.amzuni.fontstyle

import android.os.Bundle

import androidx.fragment.app.Fragment
import com.amzuni.fontstyle.base.BaseActivity
import com.amzuni.fontstyle.ui.fragment.DecoratorFragment
import com.amzuni.fontstyle.ui.fragment.GeneratorFragment
import com.amzuni.fontstyle.ui.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : BaseActivity() {
    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var fabCreate : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getConsentInfo()

        initGUI()
    }

    override fun initGUI() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.background = null

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, GeneratorFragment()).commit()
        val generatorFragment = GeneratorFragment()
        val decoratorFragment = DecoratorFragment()
        val settingFragment = SettingFragment()

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.generator -> setCurrentFragment(generatorFragment)
                R.id.decorator -> setCurrentFragment(decoratorFragment)
                R.id.setting -> setCurrentFragment(settingFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}
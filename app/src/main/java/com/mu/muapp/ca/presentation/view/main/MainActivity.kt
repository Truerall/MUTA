package com.mu.muapp.ca.presentation.view.main

import android.os.Bundle
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.view.base.BaseInjectionActivity
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : BaseInjectionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)
    }
}

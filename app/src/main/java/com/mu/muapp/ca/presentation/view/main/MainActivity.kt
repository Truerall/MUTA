package com.mu.muapp.ca.presentation.view.main

import android.os.Bundle
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.view.base.BaseActivity
import com.mu.muapp.ca.presentation.view.main.fragments.details.TransactionsDetailsFragment
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : BaseActivity(), MainRouter {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        setSupportActionBar(toolbar)
    }

    override fun openDetailsFragment(transactionId: String) {
        addFragment(TransactionsDetailsFragment.newInstance(transactionId), TransactionsDetailsFragment.TAG)
    }
}

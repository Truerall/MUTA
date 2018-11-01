package com.mu.muapp.ca.presentation.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.view.base.BasePresenterFragment

/**
 * A placeholder fragment containing a simple view.
 */
class TransactionsListFragment : BasePresenterFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}

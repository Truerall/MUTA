package com.mu.muapp.ca.presentation.view.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.view.base.BasePresenterFragment
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class TransactionsDetailsFragment : BasePresenterFragment() {
    @Inject lateinit var gson: Gson;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        print("yep - i see a gson > "+ gson)

        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}

package com.mu.muapp.ca.presentation.view.base

import android.support.v4.app.Fragment
import com.mu.muapp.R

abstract class BaseActivity : BaseInjectionActivity(){

//    override fun onSupportNavigateUp(): Boolean {
//        if (supportFragmentManager.backStackEntryCount > 0) {
//            supportFragmentManager.popBackStack()
//            return true
//        }
//        return super.onSupportNavigateUp()
//    }

    protected fun addFragment(fragment: Fragment, tag:String) { // move to base class to make code more readable
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        fragmentTransaction.add(R.id.container, fragment, tag)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
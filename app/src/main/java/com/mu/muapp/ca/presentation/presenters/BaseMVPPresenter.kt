package com.mu.muapp.ca.presentation.presenters

import com.mu.muapp.ca.presentation.view.base.BaseContract

abstract class BaseMVPPresenter<T : BaseContract.BaseView> : BaseContract.BasePresenter{

    protected var view : T? = null

    @Suppress("UNCHECKED_CAST")
    override fun start(view: BaseContract.BaseView) {
        this.view = view as? T
        // T is always inheritor of BaseView, so its ok.
        // if you will pass wrong view implementation for this presenter, you will see this during tests
        // while first launch of a view. so probably you will notice that, yah? :)
    }

    override fun stop() {
        view = null
    }
}
package com.mu.muapp.ca.presentation.presenters

import com.mu.muapp.ca.presentation.presenters.viewState.ViewState
import com.mu.muapp.ca.presentation.view.base.BaseContract

abstract class BaseMVPPresenter<T : BaseContract.BaseView> : BaseContract.BasePresenter {

    protected var view: T? = null

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

    override fun applyState(state: ViewState) {
        when (state) { //TODO add messages
            ViewState.EMPTY -> view?.showEmptyState()
            ViewState.ERROR -> view?.onError()
            ViewState.PROGRESS -> {
                println("state - enabling progress")
                view?.showProgress()
            }
        }
    }
}
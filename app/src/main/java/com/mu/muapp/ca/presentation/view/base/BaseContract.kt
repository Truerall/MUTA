package com.mu.muapp.ca.presentation.view.base

class BaseContract {
    interface BaseView {
        fun isAvailable(): Boolean

        fun onError()

        fun onError(messageId: Int)

        fun onError(message: String)

        fun showEmptyState()

        fun showEmptyState(messageId: Int)

        fun showEmptyState(message: String)

        fun showEmptyState(title: String?, message: String)

        fun showEmptyState(title: Int, message: Int)

        fun showSnack(messageId: Int)

        fun showSnack(message: String)

        fun showProgress()

        fun hideProgress()

        fun clearState()
    }

    interface BasePresenter {
        fun start(view: BaseView)
        fun stop()
    }
}
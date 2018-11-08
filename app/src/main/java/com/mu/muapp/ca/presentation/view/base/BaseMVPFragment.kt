package com.mu.muapp.ca.presentation.view.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.mu.muapp.R
import com.mu.muapp.ca.presentation.presenters.viewState.ViewState
import com.mu.muapp.ca.presentation.view.base.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.state_layout.*
import javax.inject.Inject

/*
    By default your view must be able to provide basic states - error / empty / progress.
    You can disable this using BaseMVPFragment boolean properties with related names
 */
abstract class BaseMVPFragment<PresenterType : BaseContract.BasePresenter, ViewModelType : BaseViewModel> :
    BaseInjectionFragment(),
    BaseContract.BaseView {

    @Inject
    lateinit var presenter: PresenterType

    @Inject
    lateinit var viewModel: ViewModelType

    //Custom view could be supported, but if you have need fot that - better override  all methods for that view type in inheritor class

    private var vEmpty: View? = null
    private var vError: View? = null
    private var vProgress: View? = null

    private var isEmptyViewEnabled = true
    private var isErrorViewEnabled = true
    private var isProgressViewEnabled = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewStubs()
        presenter.start(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.stop()
        vError = null
        vEmpty = null
        vProgress = null
    }

    private fun initViewStubs() {
        if (isErrorViewEnabled && vsEmpty == null || isEmptyViewEnabled && vsError == null || isProgressViewEnabled && vsProgress == null) {
            throw RuntimeException(
                "Please provide state layouts for fragment using setters( aka setErrorViewId(int id) \n" +
                        " or use default ids for layouts [R.id.vs_layout_error, R.id.vs_layout_empty, R.id.vs_progress]) \n" +
                        " or disable not used layouts with setErrorViewEnabled(boolean) /  setEmptyViewEnabled(boolean) "
            )
        }
    }

    override fun isAvailable() = (isAdded && view != null)

    override fun onError() {
        initErrorView()
        viewModel.viewState = ViewState.ERROR
        vError?.visibility = View.VISIBLE
    }

    override fun onError(messageId: Int) {
        onError(getString(messageId))
    }

    override fun onError(message: String) {
        initErrorView()
        viewModel.viewState = ViewState.ERROR
        vError?.findViewById<AppCompatTextView>(R.id.tv_error_message)?.text = message
        vError?.visibility = View.VISIBLE
    }

    override fun showEmptyState() {
        initEmptyView()
        viewModel.viewState = ViewState.EMPTY
        vEmpty?.visibility = View.VISIBLE
        println("state vEmpty " + vEmpty)
    }

    override fun showEmptyState(messageId: Int) {
        showEmptyState(getString(messageId))
    }

    override fun showEmptyState(message: String) {
        showEmptyState(null, message)
    }

    override fun showEmptyState(title: String?, message: String) {
        viewModel.viewState = ViewState.EMPTY
        initEmptyView()
        title?.let {
            vEmpty?.findViewById<AppCompatTextView>(R.id.tv_empty_title)?.text = it
        }
        vEmpty?.findViewById<AppCompatTextView>(R.id.tv_empty_message)?.text = message
        vEmpty?.visibility = View.VISIBLE
    }

    override fun showEmptyState(title: Int, message: Int) {
        showEmptyState(getString(title), getString(message))
    }

    override fun showSnack(messageId: Int) {
        showSnack(getString(messageId))
    }

    override fun showSnack(message: String) {
        view?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun showProgress() {
        initProgressView()
        viewModel.viewState = ViewState.PROGRESS
        vProgress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        vProgress?.visibility = View.GONE
    }

    override fun clearState() {
        viewModel.viewState = ViewState.IDLE
        if (isEmptyViewEnabled) vEmpty?.visibility = View.GONE
        if (isErrorViewEnabled) vError?.visibility = View.GONE
        if (isProgressViewEnabled) vProgress?.visibility = View.GONE
    }

    fun initEmptyView() {
        if (isEmptyViewEnabled) {
            vEmpty = vsEmpty.inflate()
        }
    }

    fun initErrorView() {
        if (isErrorViewEnabled) {
            vError = vsError.inflate()
        }
    }

    fun initProgressView() {
        if (isProgressViewEnabled) {
            vProgress = vsProgress.inflate()
        }
    }
}
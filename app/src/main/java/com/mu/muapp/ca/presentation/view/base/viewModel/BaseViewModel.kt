package com.mu.muapp.ca.presentation.view.base.viewModel

import com.mu.muapp.ca.presentation.presenters.viewState.ViewState

abstract class BaseViewModel(){
    var viewState: ViewState =
        ViewState.IDLE
}
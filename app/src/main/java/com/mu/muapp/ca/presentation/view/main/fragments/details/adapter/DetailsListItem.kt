package com.mu.muapp.ca.presentation.view.main.fragments.details.adapter

sealed class DetailsListItem {

    class BasicDetailsViewModel(val label:String, var data:String?) : DetailsListItem()

}
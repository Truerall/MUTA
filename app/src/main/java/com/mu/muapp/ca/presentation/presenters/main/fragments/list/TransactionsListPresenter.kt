package com.mu.muapp.ca.presentation.presenters.main.fragments.list

import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.domain.usecase.main.GetTransactionsUseCase
import com.mu.muapp.ca.presentation.presenters.BaseMVPPresenter
import io.reactivex.observers.DisposableSingleObserver
import java.lang.ref.WeakReference
import javax.inject.Inject

class TransactionsListPresenter @Inject constructor(private val getTransactionsUseCase: GetTransactionsUseCase) :
    BaseMVPPresenter<TransactionsListContract.ITransactionsListView>(),
    TransactionsListContract.ITransactionsListPresenter {

    override fun getTransactions() {
        view?.showProgress()
        getTransactionsUseCase.execute(TransactionsListObserver(WeakReference(this)))
    }

    private inner class TransactionsListObserver constructor(private val presenter: WeakReference<TransactionsListPresenter>) :
        DisposableSingleObserver<List<Transaction>>() {

        override fun onSuccess(list: List<Transaction>) {
            presenter.get()?.view?.displayTransactions(list)
            presenter.get()?.view?.hideProgress()
        }

        override fun onError(e: Throwable) {
            presenter.get()?.view?.onError()
            presenter.get()?.view?.hideProgress()
        }
    }
}
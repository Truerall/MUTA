package com.mu.muapp.ca.presentation.presenters.main.fragments.list

import com.mu.muapp.ca.data.source.api.response.TransactionsResponse
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
        DisposableSingleObserver<TransactionsResponse>() {

        override fun onSuccess(resp: TransactionsResponse) {
            presenter.get()?.view?.displayAccData(resp.account, resp.balance)
            if(resp.transactions.isEmpty()){
                presenter.get()?.view?.showEmptyState()
            } else {
                presenter.get()?.view?.displayTransactions(resp.transactions)
            }
            presenter.get()?.view?.hideProgress()
        }

        override fun onError(e: Throwable) {
            println("yep -> "+e.message)
            presenter.get()?.view?.onError()
            presenter.get()?.view?.hideProgress()
        }
    }
}
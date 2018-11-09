package com.mu.muapp.ca.presentation.presenters.main.fragments.details

import com.mu.muapp.ca.domain.entity.Transaction
import com.mu.muapp.ca.domain.usecase.main.GetTransactionDetailsUseCase
import com.mu.muapp.ca.presentation.presenters.BaseMVPPresenter
import io.reactivex.observers.DisposableSingleObserver
import java.lang.ref.WeakReference
import javax.inject.Inject

class TransactionDetailsPresenter @Inject constructor(private val getTransactionDetailsUseCase: GetTransactionDetailsUseCase) :
    BaseMVPPresenter<TransactionDetailsContract.ITransactionDetailsView>(),
    TransactionDetailsContract.ITransactionDetailsPresenter {

    override fun getTransactionDetails(transactionId: String) {
        view?.showProgress()
        getTransactionDetailsUseCase.execute(TransactionDetailsObserver(WeakReference(this)), transactionId)
    }

    override fun disposeTasks() {
        getTransactionDetailsUseCase.dispose()
    }

    private inner class TransactionDetailsObserver constructor(private val presenter: WeakReference<TransactionDetailsPresenter>) :
        DisposableSingleObserver<Transaction>() {

        override fun onSuccess(transaction: Transaction) {
            presenter.get()?.view?.displayTransactionDetails(transaction)
            presenter.get()?.view?.hideProgress()
        }

        override fun onError(e: Throwable) {
            println("yep -> "+e.message)
            presenter.get()?.view?.onError()
            presenter.get()?.view?.hideProgress()
        }
    }
}
package phucduong.demoapp.ui.list

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import phucduong.demoapp.ui.base.BasePresenter
import phucduong.demoapp.util.SchedulerProvider
import javax.inject.Inject


class ListPresenter<V : ListContract.View, I : ListContract.Interactor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), phucduong.demoapp.ui.list.ListContract.Presenter<V, I>{
    override fun onAttach(v: V?) {
        super.onAttach(v)
        getListKeyword();
    }

    override fun getListKeyword() {
        interactor?.let {
            compositeDisposable.add(it.getListKeyword()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ listUser ->
                        getView()?.displayListKeyword(listUser)
                    }, {
                        getView()?.showErrorDialog() }))
        }
    }
}
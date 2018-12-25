package phucduong.demoapp.ui.list

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import phucduong.demoapp.data.network.response.User
import phucduong.demoapp.ui.base.BasePresenter
import phucduong.demoapp.util.SchedulerProvider
import javax.inject.Inject


class ListPresenter<V : ListContract.View, I : ListContract.Interactor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), phucduong.demoapp.ui.list.ListContract.Presenter<V, I>{
    override fun onAttach(v: V?) {
        super.onAttach(v)
        getListUser(0);
    }

    override fun getListUser(lastId: Int)
    {
        interactor?.let {
            compositeDisposable.add(it.getListUser(lastId)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ listUser ->
                        getView()?.displayListUser(listUser)
                    }, {
                        getView()?.showErrorDialog() }))
        }
    }
}
package phucduong.demoapp.ui.detail

import io.reactivex.disposables.CompositeDisposable
import phucduong.demoapp.ui.base.BasePresenter
import phucduong.demoapp.ui.list.ListContract
import phucduong.demoapp.util.SchedulerProvider
import javax.inject.Inject

class DetailPresenter<V : DetailContract.View, I : DetailContract.Interactor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), DetailContract.Presenter<V, I> {
    override fun getUserDetail(loginName: String?)
    {
        getView()?.showProgress();
        interactor?.let {
            compositeDisposable.add(it.getUserDetail(loginName)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ userDetail ->
                        getView()?.hideProgress();
                        getView()?.displayUserDetail(userDetail)
                    }, {
                        getView()?.showErrorDialog() }))
        }
    }
}
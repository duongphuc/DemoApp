package phucduong.demoapp.ui.base

import io.reactivex.disposables.CompositeDisposable
import phucduong.demoapp.ui.base.Base
import phucduong.demoapp.util.SchedulerProvider

abstract class BasePresenter<V : Base.View, I : Base.Interactor> internal constructor(protected  var interactor : I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : Base.Presenter<V, I> {
    private var view : V? = null

    override fun onAttach(v: V?)  {
        view = v
    }

    override fun onDetach() {
        view = null
        interactor = null
        compositeDisposable.dispose()
    }

    override fun getView(): V? = view
}
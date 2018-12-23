package phucduong.demoapp.ui.splash

import io.reactivex.disposables.CompositeDisposable
import phucduong.demoapp.ui.base.BasePresenter
import phucduong.demoapp.util.SchedulerProvider
import javax.inject.Inject


class SplashPresenter<V : Splash.View, I : Splash.Interactor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), Splash.Presenter<V, I>{
}
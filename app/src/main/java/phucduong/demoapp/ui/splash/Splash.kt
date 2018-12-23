package phucduong.demoapp.ui.splash

import phucduong.demoapp.ui.base.Base


interface Splash {
    interface View : Base.View {

    }

    interface Interactor : Base.Interactor {

    }

    interface Presenter<V : Splash.View, I : Splash.Interactor> : Base.Presenter<V, I> {

    }
}
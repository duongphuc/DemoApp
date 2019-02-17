package phucduong.demoapp.ui.list

import io.reactivex.Observable
import phucduong.demoapp.ui.base.Base


interface ListContract {
    interface View : Base.View {
        fun displayListKeyword(listKeyword: MutableList<String>)
    }

    interface Interactor : Base.Interactor {
        fun getListKeyword(): Observable<MutableList<String>>
    }

    interface Presenter<V : ListContract.View, I : ListContract.Interactor> : Base.Presenter<V, I> {
        fun getListKeyword()
    }
}
package phucduong.demoapp.ui.list

import io.reactivex.Observable
import phucduong.demoapp.data.network.response.User
import phucduong.demoapp.ui.base.Base


interface ListContract {
    interface View : Base.View {
        fun displayListUser(listUser: List<User>?) : Unit?
    }

    interface Interactor : Base.Interactor {
        fun getListUser(lastId : Int): Observable<List<User>>
    }

    interface Presenter<V : ListContract.View, I : ListContract.Interactor> : Base.Presenter<V, I> {
        fun getListUser(lastId: Int)
    }
}
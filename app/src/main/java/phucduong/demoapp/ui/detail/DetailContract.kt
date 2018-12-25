package phucduong.demoapp.ui.detail

import io.reactivex.Observable
import phucduong.demoapp.data.network.response.User
import phucduong.demoapp.data.network.response.UserDetail
import phucduong.demoapp.ui.base.Base
import phucduong.demoapp.ui.list.ListContract

interface DetailContract {
    interface View : Base.View {
        fun displayUserDetail(userDetail: UserDetail?)
    }

    interface Interactor : Base.Interactor {
        fun getUserDetail(login : String?): Observable<UserDetail>
    }

    interface Presenter<V : DetailContract.View, I : DetailContract.Interactor> : Base.Presenter<V, I> {
        fun getUserDetail(loginName: String?)
    }
}
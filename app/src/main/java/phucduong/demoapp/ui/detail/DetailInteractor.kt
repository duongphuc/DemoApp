package phucduong.demoapp.ui.detail

import io.reactivex.Observable
import phucduong.demoapp.data.network.ApiHelper
import phucduong.demoapp.data.network.response.UserDetail
import phucduong.demoapp.data.preference.PreferenceHelper
import phucduong.demoapp.ui.base.BaseInteractor
import javax.inject.Inject

class DetailInteractor @Inject internal constructor(private val apiHelper: ApiHelper, preferenceHelper: PreferenceHelper) : BaseInteractor(apiHelper, preferenceHelper), DetailContract.Interactor {
    override fun getUserDetail(login: String?): Observable<UserDetail> = apiHelper.getUserDetail(login)
}
package phucduong.demoapp.ui.list

import io.reactivex.Observable
import phucduong.demoapp.data.network.ApiHelper
import phucduong.demoapp.data.preference.PreferenceHelper
import phucduong.demoapp.ui.base.BaseInteractor
import javax.inject.Inject


class ListInteractor @Inject internal constructor(private val apiHelper: ApiHelper, preferenceHelper: PreferenceHelper) : BaseInteractor(apiHelper, preferenceHelper), ListContract.Interactor {
    override fun getListKeyword(): Observable<MutableList<String>> = apiHelper.getListKeyword()
}
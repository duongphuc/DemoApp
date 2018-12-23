package phucduong.demoapp.ui.splash

import phucduong.demoapp.data.network.ApiHelper
import phucduong.demoapp.data.preference.PreferenceHelper
import phucduong.demoapp.ui.base.BaseInteractor
import javax.inject.Inject


class SplashInteractor @Inject internal constructor(apiHelper: ApiHelper, preferenceHelper: PreferenceHelper) : BaseInteractor(apiHelper, preferenceHelper), Splash.Interactor {
}
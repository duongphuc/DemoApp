package phucduong.demoapp.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import phucduong.demoapp.data.network.ApiHelper
import phucduong.demoapp.data.network.ApiHelperImpl
import phucduong.demoapp.data.preference.PreferenceHelper
import phucduong.demoapp.data.preference.PreferenceHelperImpl
import phucduong.demoapp.util.Constant
import phucduong.demoapp.util.SchedulerProvider
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    internal fun providePrefName() : String = Constant.PREF_NAME

    @Singleton
    @Provides
    internal fun provideSharedPreference(prefHelper : PreferenceHelperImpl) : PreferenceHelper = prefHelper

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: ApiHelperImpl): ApiHelper = appApiHelper
}
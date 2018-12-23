package phucduong.demoapp.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import phucduong.demoapp.data.preference.PreferenceHelper
import phucduong.demoapp.data.preference.PreferenceHelperImpl
import phucduong.demoapp.util.Constant
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
}
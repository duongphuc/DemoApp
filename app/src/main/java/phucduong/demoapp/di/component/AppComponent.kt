package phucduong.demoapp.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import phucduong.demoapp.MyApplication
import phucduong.demoapp.di.modules.ActivityBuilderModule
import phucduong.demoapp.di.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (ActivityBuilderModule::class), (AppModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApplication)
}
package phucduong.demoapp.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import phucduong.demoapp.ui.list.ListActivity
import phucduong.demoapp.ui.list.ListContract

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [(ListActivityModule::class)])
    abstract fun bindListActivity(): ListActivity
}
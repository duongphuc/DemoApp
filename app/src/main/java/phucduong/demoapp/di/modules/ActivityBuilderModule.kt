package phucduong.demoapp.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import phucduong.demoapp.ui.detail.DetailActivity
import phucduong.demoapp.ui.list.ListActivity
import phucduong.demoapp.ui.list.ListContract

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [(ListActivityModule::class)])
    abstract fun bindListActivity(): ListActivity

    @ContributesAndroidInjector(modules = [(DetailActivityModule::class)])
    abstract fun bindDetailActivity(): DetailActivity
}
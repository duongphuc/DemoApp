package phucduong.demoapp.di.modules

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import phucduong.demoapp.adapter.ListKeywordAdapter
import phucduong.demoapp.ui.list.ListContract
import phucduong.demoapp.ui.list.ListInteractor
import phucduong.demoapp.ui.list.ListPresenter
import java.util.ArrayList

@Module
class ListActivityModule {
    @Provides
    internal fun provideListInteractor(listInteractor: ListInteractor): ListContract.Interactor = listInteractor

    @Provides
    internal fun provideListPresenter(listPresenter: ListPresenter<ListContract.View, ListContract.Interactor>)
            : ListContract.Presenter<ListContract.View, ListContract.Interactor> = listPresenter

    @Provides
    internal fun provideListAdapter(context: Context): ListKeywordAdapter = ListKeywordAdapter(ArrayList(), context)

    @Provides
    internal fun provideLinearLayoutManager(context: Context): LinearLayoutManager = LinearLayoutManager(context)
}
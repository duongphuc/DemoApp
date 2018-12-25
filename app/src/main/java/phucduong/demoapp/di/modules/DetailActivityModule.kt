package phucduong.demoapp.di.modules

import dagger.Module
import dagger.Provides
import phucduong.demoapp.ui.detail.DetailContract
import phucduong.demoapp.ui.detail.DetailInteractor
import phucduong.demoapp.ui.detail.DetailPresenter
import phucduong.demoapp.ui.list.ListContract
import phucduong.demoapp.ui.list.ListInteractor
import phucduong.demoapp.ui.list.ListPresenter

@Module
class DetailActivityModule {
    @Provides
    internal fun provideDetailInteractor(detailInteractor : DetailInteractor): DetailContract.Interactor = detailInteractor

    @Provides
    internal fun provideListPresenter(detailPresenter : DetailPresenter<DetailContract.View, DetailContract.Interactor>)
            : DetailContract.Presenter<DetailContract.View, DetailContract.Interactor> = detailPresenter
}
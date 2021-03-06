package phucduong.demoapp.util

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider {

    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
                .observeOn(getMainThreadScheduler())
    }

    private fun getIOThreadScheduler() = Schedulers.io()

    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()

}
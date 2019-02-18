package phucduong.demoapp.data.network

import io.reactivex.Observable

interface ApiHelper {
    fun getListKeyword(): Observable<MutableList<String>>
}
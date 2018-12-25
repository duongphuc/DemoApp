package phucduong.demoapp.data.network

import io.reactivex.Observable
import phucduong.demoapp.data.network.response.User
import phucduong.demoapp.data.network.response.UserDetail

interface ApiHelper {
    fun getListUser(lastId : Int): Observable<List<User>>
    fun getUserDetail(login : String?) : Observable<UserDetail>
}
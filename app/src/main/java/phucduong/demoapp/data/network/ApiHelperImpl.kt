package phucduong.demoapp.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import phucduong.demoapp.data.network.response.User
import phucduong.demoapp.data.network.response.UserDetail
import phucduong.demoapp.util.Constant
import javax.inject.Inject
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class ApiHelperImpl @Inject constructor() : ApiHelper {

    var okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

    override fun getUserDetail(login: String?): Observable<UserDetail> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_DETAIL_USER)
                .addPathParameter("login", login)
                .setOkHttpClient(okHttpClient)
                .build()
                .getObjectObservable(UserDetail::class.java)

    override fun getListUser(lastId : Int): Observable<List<User>> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_LIST_USER)
                .addQueryParameter("since", lastId.toString())
                .addQueryParameter("per_page", Constant.ITEM_PER_PAGE.toString())
                .setOkHttpClient(okHttpClient)
                .build()
                .getObjectListObservable(User::class.java )
}
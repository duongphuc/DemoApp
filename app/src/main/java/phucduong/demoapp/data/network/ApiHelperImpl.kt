package phucduong.demoapp.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
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

    override fun getListKeyword(): Observable<MutableList<String>> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_LIST_KEYWORD)
                    .setOkHttpClient(okHttpClient)
                    .build()
                    .getObjectListObservable(String::class.java)
}
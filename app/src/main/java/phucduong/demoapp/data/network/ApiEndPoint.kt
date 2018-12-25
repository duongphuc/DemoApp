package phucduong.demoapp.data.network

import phucduong.demoapp.BuildConfig

object ApiEndPoint {
    val ENDPOINT_LIST_USER = BuildConfig.BASE_URL + "/users"
    val ENDPOINT_DETAIL_USER = ENDPOINT_LIST_USER + "/{login}"
}
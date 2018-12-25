package phucduong.demoapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User internal constructor(   @Expose
                                        @SerializedName("id")
                                        var id : Int,
                                        @Expose
                                        @SerializedName("avatar_url")
                                        var avatar: String? = null,
                                        @Expose
                                        @SerializedName("login")
                                        var loginName: String? = null,
                                        @Expose
                                         @SerializedName("site_admin")
                                         var siteAdmin: Boolean = false)
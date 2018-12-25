package phucduong.demoapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDetail internal constructor(
                                              @Expose
                                              @SerializedName("avatar_url")
                                              var avatar : String? = null,
                                              @Expose
                                              @SerializedName("name")
                                              var name : String? = null,
                                              @Expose
                                              @SerializedName("site_admin")
                                              var siteAdmin : Boolean = false,
                                              @Expose
                                              @SerializedName("bio")
                                              var bio : String? = null,
                                              @Expose
                                              @SerializedName("login")
                                              var login : String? = null,
                                              @Expose
                                              @SerializedName("location")
                                              var location : String? = null,
                                              @Expose
                                              @SerializedName("blog")
                                              var blog : String? = null
                                            )
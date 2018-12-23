package phucduong.demoapp.data.preference

import android.content.Context
import javax.inject.Inject

class PreferenceHelperImpl @Inject constructor(context: Context, prefName : String) : PreferenceHelper {

    private val prefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
}
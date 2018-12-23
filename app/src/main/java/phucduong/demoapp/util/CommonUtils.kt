package phucduong.demoapp.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import phucduong.demoapp.R

object CommonUtils {
    fun showDialog(context : Context) : ProgressDialog {
        val dialog = ProgressDialog(context)
        dialog.let { it.show()
            it.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it }
    }
}
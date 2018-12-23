package phucduong.demoapp.ui.base

import android.app.ProgressDialog
import dagger.android.support.DaggerAppCompatActivity
import phucduong.demoapp.util.CommonUtils

abstract class BaseActivity : DaggerAppCompatActivity(), Base.View {
    private var progressDialog : ProgressDialog? = null
    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel()}
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showDialog(this)
    }
}
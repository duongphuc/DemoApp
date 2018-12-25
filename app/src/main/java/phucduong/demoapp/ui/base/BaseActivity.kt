package phucduong.demoapp.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import phucduong.demoapp.util.CommonUtils

abstract class BaseActivity : AppCompatActivity(), Base.View {
    private var progressDialog : ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel()}
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showDialog(this)
    }

    override fun showErrorDialog() {
        hideProgress()
        AlertDialog.Builder(this)
                .setTitle("System Error")
                .setMessage("Something went wrong. Please try again later")
                .setPositiveButton("OK", { dialog, whichButton ->

                })
                .show()
    }
}
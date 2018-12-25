package phucduong.demoapp.ui.detail

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_user_staff.*
import phucduong.demoapp.R
import phucduong.demoapp.data.network.response.UserDetail
import phucduong.demoapp.ui.base.BaseActivity
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View {
    @Inject
    lateinit var presenter: DetailContract.Presenter<DetailContract.View, DetailContract.Interactor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        setContentView(R.layout.activity_detail)

        val loginName = intent?.extras?.getString("login")
        presenter.getUserDetail(loginName);
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun displayUserDetail(userDetail: UserDetail?) {
        Glide.with(this).load(userDetail?.avatar).apply(RequestOptions.circleCropTransform()).into(imageView)
        name.text = userDetail?.name
        bio.text = userDetail?.bio
        login.text = userDetail?.login
        staff.visibility = if (userDetail?.siteAdmin?: false) View.VISIBLE else View.GONE
        location.text = userDetail?.location
        blog.text = userDetail?.blog
        close.setOnClickListener({ finish() })
    }
}
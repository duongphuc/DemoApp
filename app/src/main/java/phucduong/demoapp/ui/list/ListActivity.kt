package phucduong.demoapp.ui.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import phucduong.demoapp.R
import phucduong.demoapp.adapter.ListUserAdapter
import phucduong.demoapp.data.network.response.User
import phucduong.demoapp.ui.base.BaseActivity
import phucduong.demoapp.util.PaginationScrollListener
import javax.inject.Inject

class ListActivity : BaseActivity(), ListContract.View {
    @Inject
    lateinit var presenter: ListContract.Presenter<ListContract.View, ListContract.Interactor>
    @Inject
    internal lateinit var adapter: ListUserAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var lastId : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                isLoading = true
                showProgressPagingView()
                presenter.getListUser(lastId)
            }
        })
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun displayListUser(listUser: List<User>?) = listUser?.let {
        hideProgressPagingView()
        isLoading = false
        if (it.size > 0) lastId = it.get(it.size - 1).id else isLastPage = true
        adapter.addDataToList(it)
    }

    fun showProgressPagingView() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressPagingView() {
        progressBar.visibility = View.INVISIBLE
    }
}
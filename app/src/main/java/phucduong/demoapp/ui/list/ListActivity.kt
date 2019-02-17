package phucduong.demoapp.ui.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import phucduong.demoapp.R
import phucduong.demoapp.adapter.ListKeywordAdapter
import phucduong.demoapp.ui.base.BaseActivity
import javax.inject.Inject

class ListActivity : BaseActivity(), ListContract.View {
    @Inject
    lateinit var presenter: ListContract.Presenter<ListContract.View, ListContract.Interactor>
    @Inject
    internal lateinit var adapter: ListKeywordAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun displayListKeyword(listKeyword: MutableList<String>) {
        adapter.addDataToList(listKeyword)
    }
}
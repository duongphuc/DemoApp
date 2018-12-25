package phucduong.demoapp.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_user_list.view.*
import kotlinx.android.synthetic.main.layout_user_staff.view.*
import phucduong.demoapp.R
import phucduong.demoapp.data.network.response.User
import phucduong.demoapp.ui.detail.DetailActivity

class ListUserAdapter (val data : MutableList<User>, val context: Context) : RecyclerView.Adapter<ListUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, p1: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent?.context)
    .inflate(R.layout.item_user_list, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.onBind(position)
    }

    internal fun addDataToList(listUser: List<User>) {
        this.data.addAll(listUser)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view)  {

        fun clear() {
            itemView.image.setImageDrawable(null)
            itemView.login.text = ""
            itemView.staff.visibility = View.GONE
        }

        fun onBind(position: Int) {
            clear()
            val (id, avatar, loginName, siteAdmin) = data[position]
            itemView.login.text = loginName
            itemView.staff.visibility = if (siteAdmin) View.VISIBLE else View.GONE
            Glide.with(context).load(avatar).apply(RequestOptions.circleCropTransform()).into(itemView.image)
            setItemClickListener(loginName)
        }

        private fun setItemClickListener(loginName: String?) {
            itemView.setOnClickListener {
                loginName?.let {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("login", loginName)
                    itemView.context.startActivity(intent)
                }

            }
        }
    }
}
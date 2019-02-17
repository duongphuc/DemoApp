package phucduong.demoapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_keyword.view.*
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.widget.Toast
import phucduong.demoapp.R
import java.util.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.Drawable

class ListKeywordAdapter (val data : MutableList<String>, val context: Context) : RecyclerView.Adapter<ListKeywordAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup, p1: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context)
    .inflate(R.layout.item_keyword, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.onBind(position)
    }

    internal fun addDataToList(listKeyword : MutableList<String>) {
        this.data.addAll(listKeyword)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view)  {

        fun clear() {
            itemView.keyword.text = "";
        }

        fun onBind(position: Int) {
            clear()
            val keyword = data[position]
            itemView.keyword.text = keyword
            setBackground()
        }

        private fun setBackground() {
            val background = itemView.keywordContainer.getBackground()
            if (background is ShapeDrawable) {
                background.paint.color = getRandomBackgroundColor()
            } else if (background is GradientDrawable) {
                background.setColor(getRandomBackgroundColor())
            } else if (background is ColorDrawable) {
                background.color = getRandomBackgroundColor()
            }
        }

        private fun getRandomBackgroundColor() : Int {
            val rnd = Random()
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        }
    }
}
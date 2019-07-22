package com.astronout.testmagangdotkotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.astronout.testmagangdotkotlin.DetailActivity
import com.astronout.testmagangdotkotlin.R
import com.astronout.testmagangdotkotlin.model.Malang
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*

class MalangAdapter(private val malangs: List<Malang>) : RecyclerView.Adapter<MalangAdapter.ViewHolder>() {

    private lateinit var context: Context
    private val EXTRA_CAPTION: String = "CAPTION"
    private val EXTRA_IMAGE: String = "IMAGE"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = malangs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(malangs[position].image)
            .into(holder.imageView)

        holder.itemView.setOnClickListener{
//            Toast.makeText(context, malangs[position].caption, Toast.LENGTH_SHORT).show()
            val intent = Intent(this.context, DetailActivity::class.java)
            intent.putExtra(EXTRA_CAPTION, malangs[position].caption)
            intent.putExtra(EXTRA_IMAGE, malangs[position].image)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.img_poster

    }

}
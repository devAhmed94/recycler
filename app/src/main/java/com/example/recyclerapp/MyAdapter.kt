package com.example.recyclerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 19/04/2021
 */
class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var list = ArrayList<PostModel>()
    private lateinit var listener: OnClickItemRecycler
    fun setList(myList: ArrayList<PostModel>) {
        list = myList
    }

    fun setListener(_listener: OnClickItemRecycler) {
        listener = _listener
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var name = item.findViewById<AppCompatTextView>(R.id.tvName)
        var image = item.findViewById<AppCompatImageView>(R.id.ivImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = list[position].name
        Picasso.with(holder.itemView.context).load(list[position].image).into(holder.image)
        holder.itemView.setOnClickListener {
            if (::listener.isInitialized) {
                listener.onClickItem(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
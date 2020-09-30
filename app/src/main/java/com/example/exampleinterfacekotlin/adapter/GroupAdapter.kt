package com.example.exampleinterfacekotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleinterfacekotlin.R
import com.example.exampleinterfacekotlin.model.Group
import de.hdodenhof.circleimageview.CircleImageView

class GroupAdapter(
    private val mList: List<Group>
) : RecyclerView.Adapter<GroupAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listgroup, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: GroupAdapter.ItemViewHolder, position: Int) {
        holder.textView.text = "" + mList[position].mName.toCharArray()[0]
    }

    inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById(R.id.circleImageView) as CircleImageView
        val textView = itemView.findViewById(R.id.tvName) as TextView
    }

}
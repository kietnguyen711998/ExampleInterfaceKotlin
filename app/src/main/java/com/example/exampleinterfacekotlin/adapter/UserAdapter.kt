package com.example.exampleinterfacekotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleinterfacekotlin.R
import com.example.exampleinterfacekotlin.`interface`.OnItemClick
import com.example.exampleinterfacekotlin.model.User

class UserAdapter(
    private val mList: List<User>,
    private val mListener: OnItemClick
) : RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_listuser, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tvName.text = mList[position].mName
        holder.tvAddress.text = mList[position].mAddress
        holder.tvClick.setOnClickListener {
            mListener.onView(position)
        }
        holder.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            mListener.onCheck(position, true)
        }

    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView = itemView.findViewById(R.id.image) as ImageView
        val cardView = itemView.findViewById(R.id.cardview) as CardView
        val checkBox = itemView.findViewById(R.id.checkbox) as CheckBox
        val tvName = itemView.findViewById(R.id.tvName) as TextView
        val tvAddress = itemView.findViewById(R.id.tvAddress) as TextView
        val tvClick = itemView.findViewById(R.id.button) as TextView
    }
}
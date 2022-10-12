package com.sak.sameertrail.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sak.sameertrail.R


class ChildItem3Adapter  // Constructor
internal constructor(private val ChildItemList: List<Any>) :
    RecyclerView.Adapter<ChildItem3Adapter.ChildViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ChildViewHolder {

        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.child_item3,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        childViewHolder: ChildViewHolder,
        position: Int
    ) {
        val childItem = ChildItemList[position]
        //childViewHolder.ChildItemImage.setImageURI()
    }

    override fun getItemCount(): Int {

        return ChildItemList.size
    }

    inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var ChildItemImage: ImageView

        init {
            ChildItemImage = itemView.findViewById(
                R.id.img_child_item3
            )
        }
    }
}
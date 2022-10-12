package com.sak.sameertrail.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.internal.LinkedTreeMap
import com.sak.sameertrail.R
import com.sak.sameertrail.data.models.response.Items

class ChildItemAdapter  // Constructor
internal constructor(private val ChildItemList: List<LinkedTreeMap<String, Any>>,private val context : Context) :
    RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ChildViewHolder {

        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.child_item,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        childViewHolder: ChildViewHolder,
        position: Int
    ) {

        childViewHolder.ChildItemTitle.text = "${ChildItemList[position]["name"]}"
        Glide
            .with(context)
            .load(ChildItemList[position]["logo"])
            .placeholder(R.drawable.ic_launcher_background)
            .into(childViewHolder.ChildItemImg)
    }

    override fun getItemCount(): Int {

        return ChildItemList.size
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var ChildItemTitle: TextView
        var ChildItemImg : ImageView

        init {
            ChildItemTitle = itemView.findViewById(
                R.id.child_item_title
            )
            ChildItemImg = itemView.findViewById(
                R.id.img_child_item
            )
        }
    }
}
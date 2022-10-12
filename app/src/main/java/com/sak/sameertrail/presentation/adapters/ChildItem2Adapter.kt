package com.sak.sameertrail.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.internal.LinkedTreeMap
import com.sak.sameertrail.R
import com.sak.sameertrail.data.models.response.Items


class ChildItem2Adapter  // Constructor
internal constructor(private val ChildItem2List: List<LinkedTreeMap<String, Any>>) :
    RecyclerView.Adapter<ChildItem2Adapter.ChildViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ChildViewHolder {

        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.child_item2,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        childViewHolder: ChildViewHolder,
        position: Int
    ) {

       // Log.d("SAK","${ChildItem2List[position]["name"]}")

        childViewHolder.ChildItemTitle.text = "${ChildItem2List[position]["name"]}"
    }

    override fun getItemCount(): Int {

        return ChildItem2List.size
    }

    inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var ChildItemTitle: TextView

        init {
            ChildItemTitle = itemView.findViewById(
                R.id.child2_item_title
            )
        }
    }
}
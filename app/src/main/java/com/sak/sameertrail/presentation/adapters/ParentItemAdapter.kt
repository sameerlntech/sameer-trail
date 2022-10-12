package com.sak.sameertrail.presentation.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridLayout.HORIZONTAL
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.bumptech.glide.Glide
import com.google.gson.internal.LinkedTreeMap
import com.sak.sameertrail.R
import com.sak.sameertrail.data.models.response.Section


class ParentItemAdapter  constructor(private val itemList: ArrayList<Section>, private val context : Context) :
    RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>() {

    private val viewPool = RecycledViewPool()
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ParentViewHolder {

        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.parent_item,
                viewGroup, false
            )
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(
        parentViewHolder: ParentViewHolder,
        position: Int
    ) {

        val parentItem = itemList[position]

        if(itemList[position].background_color != null) parentViewHolder.MainContainer.setBackgroundColor(Color.parseColor(itemList[position].background_color))
        if (itemList[position].is_see_all_shown == true) parentViewHolder.SeeMore.visibility = View.VISIBLE

        when (parentItem.type){
            "banner_large" -> {
                parentViewHolder.BannerImg.layoutParams.height = 333
                parentViewHolder.ParentItemTitle.visibility = View.GONE
                parentViewHolder.List.visibility = View.GONE
                parentViewHolder.Banner.visibility = View.VISIBLE
                val list = parentItem.items as LinkedTreeMap<String,Any>
                Glide
                    .with(context)
                    .load(list["image"])
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(parentViewHolder.BannerImg)
            }
            "banner_small" -> {
                parentViewHolder.ParentItemTitle.visibility = View.GONE
                parentViewHolder.List.visibility = View.GONE
                parentViewHolder.Banner.visibility = View.VISIBLE

                val list = parentItem.items as LinkedTreeMap<String,Any>
                Glide
                    .with(context)
                    .load(list["image"])
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(parentViewHolder.BannerImg)
            }
            "category" -> {
                parentViewHolder.ParentItemTitle.text = parentItem.title
                parentViewHolder.List.visibility = View.VISIBLE
               // recyclerView.setLayoutManager(GridLayoutManager(this, numberOfColumns))

                val layoutManager = GridLayoutManager(
                    parentViewHolder.ChildRecyclerView
                        .context,
                    2,
                    GridLayoutManager.HORIZONTAL,
                    false
                )


                val list = parentItem.items as List<LinkedTreeMap<String,Any>>

                layoutManager.initialPrefetchItemCount = list.size
                val childItemAdapter = ChildItem2Adapter(list)
                parentViewHolder.ChildRecyclerView.layoutManager = layoutManager
                parentViewHolder.ChildRecyclerView.adapter = childItemAdapter
                parentViewHolder.ChildRecyclerView
                    .setRecycledViewPool(viewPool)
            }
            "brand" -> {
                parentViewHolder.ParentItemTitle.text = parentItem.title
                parentViewHolder.List.visibility = View.VISIBLE
                val layoutManager = LinearLayoutManager(
                    parentViewHolder.ChildRecyclerView
                        .context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                val list = parentItem.items as List<LinkedTreeMap<String,Any>>
                layoutManager.initialPrefetchItemCount = list.size
                val childItemAdapter = ChildItemAdapter(list,context)
                parentViewHolder.ChildRecyclerView.layoutManager = layoutManager
                parentViewHolder.ChildRecyclerView.adapter = childItemAdapter
                parentViewHolder.ChildRecyclerView.setRecycledViewPool(viewPool)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ParentViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val ParentItemTitle: TextView
        val ChildRecyclerView: RecyclerView
        val SeeMore : TextView
        val Banner : CardView
        val List : LinearLayout
        val BannerImg : ImageView
        val MainContainer : LinearLayout

        init {
            ParentItemTitle = itemView
                .findViewById(
                    R.id.parent_item_title
                )
            ChildRecyclerView = itemView.findViewById(R.id.child_recyclerview)
            Banner = itemView.findViewById(R.id.banner)
            List = itemView.findViewById(R.id.list)
            SeeMore = itemView.findViewById(R.id.see_more)
            BannerImg = itemView.findViewById(R.id.img_child_item3)
            MainContainer = itemView.findViewById(R.id.parent_lay)
        }
    }
}
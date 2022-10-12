package com.sak.sameertrail.data.models.response

import com.google.gson.annotations.SerializedName

data class Section (
    @SerializedName("id")
    val id : Int ?= null,
    @SerializedName("title")
    val title : String ?= null,
    @SerializedName("is_see_all_shown")
    val is_see_all_shown : Boolean ?= null,
    @SerializedName("type")
    val type : String ?= null,
    @SerializedName("background_color")
    val background_color : String ?= null,
    @SerializedName("items")
    val items : Any ?= null,
)

data class Items (
    @SerializedName("id")
    val id : Int ?= null,
    @SerializedName("name")
    val name : String ?= null,
    @SerializedName("logo")
    val logo : String ?= null,
    @SerializedName("image")
    val image : String ?= null,
)

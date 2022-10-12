package com.sak.sameertrail.data.models.response

import com.google.gson.annotations.SerializedName
import retrofit2.Response

data class DashboardResponse(
    @SerializedName("data")
    val data : ArrayList<Section>
)


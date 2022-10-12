package com.sak.sameertrail.data.datasource.remoteDataSource

import com.sak.sameertrail.data.models.response.DashboardResponse
import retrofit2.Response


interface RemoteDataSource {
    suspend fun getData() : Response<DashboardResponse>
}
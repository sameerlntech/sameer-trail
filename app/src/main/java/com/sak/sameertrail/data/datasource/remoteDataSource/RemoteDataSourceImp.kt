package com.sak.sameertrail.data.datasource.remoteDataSource

import com.sak.sameertrail.data.models.response.DashboardResponse
import com.sak.sameertrail.data.networking.ApiClient
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val apiClient: ApiClient
) : RemoteDataSource{
    override suspend fun getData(): Response<DashboardResponse> {
        return apiClient.getData()
    }

}
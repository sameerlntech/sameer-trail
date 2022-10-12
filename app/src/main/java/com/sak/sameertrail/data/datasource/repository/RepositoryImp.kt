package com.sak.sameertrail.data.datasource.repository

import com.sak.sameertrail.data.datasource.remoteDataSource.RemoteDataSourceImp
import com.sak.sameertrail.data.models.response.DashboardResponse
import com.sak.sameertrail.data.models.response.Section
import com.sak.sameertrail.data.utils.Resource
import com.sak.sameertrail.domain.repository.Repository
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val remoteDataSourceImp: RemoteDataSourceImp
) : Repository {

    fun convertListRequest(data: Response<DashboardResponse>): Resource<ArrayList<Section>>{
        if (data.isSuccessful){
            data.body()?.data?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error("Error")
    }
    override suspend fun getData(): Resource<ArrayList<Section>> {
        return convertListRequest(remoteDataSourceImp.getData())
    }

}
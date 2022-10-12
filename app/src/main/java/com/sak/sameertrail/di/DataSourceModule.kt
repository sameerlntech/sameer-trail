package com.sak.sameertrail.di

import com.sak.sameertrail.data.datasource.remoteDataSource.RemoteDataSourceImp
import com.sak.sameertrail.data.networking.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        apiClient: ApiClient
    ) : RemoteDataSourceImp {
        return RemoteDataSourceImp(apiClient)
    }

}
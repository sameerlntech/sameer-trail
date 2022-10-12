package com.sak.sameertrail.di

import com.sak.sameertrail.data.datasource.remoteDataSource.RemoteDataSourceImp
import com.sak.sameertrail.data.datasource.repository.RepositoryImp
import com.sak.sameertrail.data.networking.ApiClient
import com.sak.sameertrail.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSourceImp: RemoteDataSourceImp
    ) : Repository {
        return RepositoryImp(remoteDataSourceImp)
    }
}
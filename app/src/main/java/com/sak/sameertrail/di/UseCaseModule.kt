package com.sak.sameertrail.di

import com.sak.sameertrail.data.datasource.remoteDataSource.RemoteDataSourceImp
import com.sak.sameertrail.data.datasource.repository.RepositoryImp
import com.sak.sameertrail.domain.repository.Repository
import com.sak.sameertrail.domain.usecases.Data
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(
        repositoryImp: RepositoryImp
    ) : Data {
        return Data(repositoryImp)
    }
}
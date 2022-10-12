package com.sak.sameertrail.di

import com.sak.sameertrail.data.datasource.repository.RepositoryImp
import com.sak.sameertrail.domain.usecases.Data
import com.sak.sameertrail.presentation.ui.dashboard.DashboardViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModel(
        data: Data
    ) : DashboardViewModel {
        return DashboardViewModel(data)
    }
}
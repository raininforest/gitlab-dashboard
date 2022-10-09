package com.github.raininforest.dashboard_user_mr.di

import com.github.raininforest.dashboard_user_mr.repository.MRDashboardRepository
import com.github.raininforest.dashboard_user_mr.repository.MRDashboardStatisticsBuilder
import com.github.raininforest.dashboard_user_mr.repository.remote.MRDashboardRemote
import com.github.raininforest.dashboard_user_mr.repository.remote.PaginatedRemoteMrDataSource
import com.github.raininforest.datepicker.service.DateStorage
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object MRDashboardModule {
    @MRDashboardScope
    @Provides
    fun provideMRDashboardRemote(retrofit: Retrofit): MRDashboardRemote = retrofit.create(MRDashboardRemote::class.java)

    @MRDashboardScope
    @Provides
    fun provideMRDashboardStatisticsBuilder(): MRDashboardStatisticsBuilder = MRDashboardStatisticsBuilder()

    @MRDashboardScope
    @Provides
    fun providePaginatedRemoteMrDataSource(
        mrDashboardRemote: MRDashboardRemote
    ): PaginatedRemoteMrDataSource = PaginatedRemoteMrDataSource(mrDashboardRemote)

    @MRDashboardScope
    @Provides
    fun provideMRDashboardRepository(
        paginatedRemoteMrDataSource: PaginatedRemoteMrDataSource,
        mrDashboardStatisticsBuilder: MRDashboardStatisticsBuilder
    ): MRDashboardRepository =
        MRDashboardRepository(
            paginatedRemoteMrDataSource = paginatedRemoteMrDataSource,
            dashboardStatisticsBuilder = mrDashboardStatisticsBuilder,
        )
}

@Module
interface DateStorageModule {
    @MRDashboardScope
    @Binds
    fun bindDateStorage(impl: MRDashboardRepository): DateStorage
}

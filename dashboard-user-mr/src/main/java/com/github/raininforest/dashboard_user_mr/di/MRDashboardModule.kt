package com.github.raininforest.dashboard_user_mr.di

import com.github.raininforest.dashboard_user_mr.repository.DateHelper
import com.github.raininforest.dashboard_user_mr.repository.MRDashboardRepository
import com.github.raininforest.dashboard_user_mr.repository.MRDashboardStatisticsBuilder
import com.github.raininforest.dashboard_user_mr.repository.remote.MRDashboardRemote
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
    fun provideMRDashboardRepository(
        mrDashboardRemote: MRDashboardRemote,
        mrDashboardStatisticsBuilder: MRDashboardStatisticsBuilder
    ): MRDashboardRepository =
        MRDashboardRepository(
            dashboardRemote = mrDashboardRemote,
            dashboardStatisticsBuilder = mrDashboardStatisticsBuilder,
            dateHelper = DateHelper()
        )
}

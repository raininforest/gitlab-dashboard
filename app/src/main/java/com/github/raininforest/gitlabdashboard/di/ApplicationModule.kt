package com.github.raininforest.gitlabdashboard.di

import android.content.Context
import com.github.raininforest.core.service.InitializationService
import com.github.raininforest.core.service.PreferenceService
import com.github.raininforest.gitlabdashboard.interceptor.UrlInterceptor
import com.github.raininforest.gitlabdashboard.service.InitializationServiceImpl
import com.github.raininforest.gitlabdashboard.service.PreferenceServiceImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object ApplicationModule {

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(initializationService: InitializationService): OkHttpClient =
        OkHttpClient.Builder()
            .protocols(listOf(Protocol.HTTP_1_1))
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(UrlInterceptor(initializationService))
            .retryOnConnectionFailure(true)
            .build()

    @Provides
    @ApplicationScope
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @ApplicationScope
    fun provideBaseUrlService(preferenceService: PreferenceService): InitializationService =
        InitializationServiceImpl(preferenceService)

    @Provides
    @ApplicationScope
    fun providePreferenceManager(context: Context): PreferenceService = PreferenceServiceImpl(context)
}
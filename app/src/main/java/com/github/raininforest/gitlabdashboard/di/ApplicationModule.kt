package com.github.raininforest.gitlabdashboard.di

import com.github.raininforest.core.InitializationService
import com.github.raininforest.gitlabdashboard.interceptor.UrlInterceptor
import com.github.raininforest.gitlabdashboard.service.InitializationServiceImpl
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
    fun provideBaseUrlService(): InitializationService = InitializationServiceImpl()
}
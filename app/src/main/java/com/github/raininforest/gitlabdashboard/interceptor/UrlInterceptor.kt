package com.github.raininforest.gitlabdashboard.interceptor

import com.github.raininforest.core.InitializationService
import okhttp3.Interceptor
import okhttp3.Response

class UrlInterceptor(private val initializationService: InitializationService) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        val originalUrl = chain.request().url
        val newUrl = originalUrl.newBuilder().apply {
            removePathSegment(0)
            scheme(SCHEME)
            host(initializationService.getAuthData().host)
            addPathSegment(API_PATH_SEGMENT)
            addPathSegment(API_VERSION_PATH_SEGMENT)
            addPathSegment(PROJECTS_PATH_SEGMENT)
            addPathSegment(initializationService.getAuthData().projectId)
            addPathSegments(originalUrl.pathSegments.joinToString("/"))

            setQueryParameter(PRIVATE_TOKEN_PARAMETER, initializationService.getAuthData().token)
        }
            .build()

        builder.url(newUrl)

        return chain.proceed(builder.build())
    }

    companion object {
        private const val SCHEME = "https"
        private const val API_PATH_SEGMENT = "api"
        private const val API_VERSION_PATH_SEGMENT = "v4"
        private const val PROJECTS_PATH_SEGMENT = "projects"
        private const val PRIVATE_TOKEN_PARAMETER = "private_token"
    }
}
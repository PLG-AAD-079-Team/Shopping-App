package com.philipademba.takehome.di.modules.shared

import com.philipademba.takehome.BuildConfig
import com.philipademba.takehome.di.qualifiers.AppIdInterceptorOkHttpClient
import com.philipademba.takehome.di.qualifiers.LoggingInterceptorOkHttpClient
import com.philipademba.takehome.shared.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoreNetworkModule {

    @LoggingInterceptorOkHttpClient
    @Singleton
    @Provides
    fun providesLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttp(
        @LoggingInterceptorOkHttpClient loggingInterceptor: Interceptor,
        @AppIdInterceptorOkHttpClient appIdInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().run {
            addInterceptor(loggingInterceptor)
            addInterceptor(appIdInterceptor)
            build()
        }
    }

    @AppIdInterceptorOkHttpClient
    @Singleton
    @Provides
    fun provideAppIdInterceptor(): Interceptor = Interceptor {
        val request = it.request()
        it.proceed(
            when (request.method) {
                Constants.REQUEST_TYPE_GET -> {
                    val url = request.url
                    request.newBuilder()
                        .url(
                            url.newBuilder()
                                .addQueryParameter(Constants.API_KEY_NAME, BuildConfig.TMDB_API_KEY)
                                .build()
                        )
                        .build()
                }

                else -> request
            }
        )
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .build()


}
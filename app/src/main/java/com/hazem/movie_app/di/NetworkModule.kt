package com.hazem.movie_app.di

import android.content.Context
import android.net.ConnectivityManager
import com.hazem.movie_app.data.network.ApiService
import com.hazem.movie_app.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.readTimeout(40, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(40, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(40, TimeUnit.SECONDS)
        okHttpClient.callTimeout(40, TimeUnit.SECONDS)
        return okHttpClient.build()
    }

    @Provides
    fun provideMovieApi(client: OkHttpClient): ApiService {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    fun checkInternetConnection(context: Context): ConnectivityManager {
        return context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
    }
}
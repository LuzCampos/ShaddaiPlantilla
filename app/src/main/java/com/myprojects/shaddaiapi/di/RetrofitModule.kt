package com.myprojects.shaddaiapi.di

import com.myprojects.shaddaiapi.data.remote.ShaddaiApi
import com.myprojects.shaddaiapi.util.Constants.Companion.BASE_URL
import com.myprojects.shaddaiapi.util.Constants.Companion.BASE_URL_localhost
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideGameApi(retrofit: Retrofit): ShaddaiApi {
        return retrofit.create(ShaddaiApi::class.java)
    }
}
package com.asynclabs.asyncsport.di

import com.asynclabs.asyncsport.data.repository.impl.AthletesRepositoryImpl
import com.asynclabs.asyncsport.data.remote.AsyncLabAPI
import com.asynclabs.asyncsport.data.repository.AthletesRepository
import com.asynclabs.asyncsport.data.repository.FeedsRepository
import com.asynclabs.asyncsport.data.repository.impl.FeedsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    private const val BASE_URL = "https://private-anon-79c451e7ce-technicaltaskapi.apiary-mock.com/"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): AsyncLabAPI =
        retrofit.create(AsyncLabAPI::class.java)

    @Singleton
    @Provides
    fun providesAthletesRepository(apiService: AsyncLabAPI):AthletesRepository = AthletesRepositoryImpl(apiService)

    @Singleton
    @Provides
    fun providesFeedsRepository(apiService: AsyncLabAPI):FeedsRepository = FeedsRepositoryImpl(apiService)
}
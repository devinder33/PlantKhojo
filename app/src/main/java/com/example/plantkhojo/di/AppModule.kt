package com.example.plantkhojo.di

import com.example.plantkhojo.core.common.ApiUrls.BASE_URL
import com.example.plantkhojo.data.remote.ApiService
import com.example.plantkhojo.data.repository.CharacterRepositoryImpl
import com.example.plantkhojo.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideCharacterRepository(api: ApiService) : CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}
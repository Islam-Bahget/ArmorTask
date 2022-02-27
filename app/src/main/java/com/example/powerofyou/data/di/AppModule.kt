package com.example.powerofyou.data.di

import com.example.powerofyou.data.network.ArmorApi
import com.example.powerofyou.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideArmorApi(remoteDataSource: RemoteDataSource): ArmorApi {
        return remoteDataSource.buildApi(ArmorApi::class.java)
    }
}
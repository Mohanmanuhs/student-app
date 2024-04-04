package com.example.studentapp.di

import com.example.studentapp.data.repository.RemoteDataSourceImpl
import com.example.studentapp.domain.repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesHttpClient(): HttpClient {
        return HttpClient(OkHttp) {
            defaultRequest {
                url("http://192.168.85.198:8081")
            }
            install(Logging) {
                logger = Logger.SIMPLE

            }
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                        isLenient=true
                    }
                )
            }
        }
    }

    @Provides
    @Singleton
    fun providesRemoteDataSource(httpClient: HttpClient): RemoteDataSource {
        return RemoteDataSourceImpl(httpClient)
    }

}



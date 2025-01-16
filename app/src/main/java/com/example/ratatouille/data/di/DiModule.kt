package com.example.ratatouille.data.di

import com.example.domain.repository.DatastoreRepository
import com.example.ratatouille.data.repository.DefaultDatastoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindDataStoreRepository(
        datastoreRepository: DefaultDatastoreRepository,
    ): DatastoreRepository

}
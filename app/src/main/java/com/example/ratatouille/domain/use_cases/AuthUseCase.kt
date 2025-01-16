package com.example.ratatouille.domain.use_cases

import com.example.domain.repository.DatastoreRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val datastore: DatastoreRepository
) {

    suspend fun getUser(): Boolean {
        return datastore.getUser() ?: false
    }

    suspend fun updateUser(bool: Boolean) {
        datastore.saveUser(bool)
    }

}
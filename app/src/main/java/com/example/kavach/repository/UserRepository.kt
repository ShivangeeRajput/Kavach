package com.example.kavach.repository

import com.Data.User
import com.example.kavach.api.ApiService
import javax.inject.Inject

interface UserRepository {
    suspend fun registerUser(user: User): Result<User>
    suspend fun loginUser(phoneNumber: String, otp: String): Result<User>

}

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override suspend fun registerUser(user: User): Result<User> {

    }

    override suspend fun loginUser(phoneNumber: String, otp: String): Result<User> {

    }


}

package com.example.api

import com.example.models.User
import com.google.android.gms.common.api.Response

interface ApiService {
    @POST("user/register")
    suspend fun registerUser(@Body user: User): Response<User>

    @POST("user/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<User>


}

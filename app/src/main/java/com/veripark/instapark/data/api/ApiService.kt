package com.veripark.instapark.data.api

import com.veripark.instapark.data.model.Address
import com.veripark.instapark.data.model.Company
import com.veripark.instapark.data.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<Users>>

    @GET("address")
    suspend fun getAddress(): Response<List<Address>>

    @GET("company")
    suspend fun getCompany(): Response<List<Company>>
}
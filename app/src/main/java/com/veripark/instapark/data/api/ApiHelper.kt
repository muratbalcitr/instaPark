package com.veripark.instapark.data.api

import com.veripark.instapark.data.model.Address
import com.veripark.instapark.data.model.Company
import com.veripark.instapark.data.model.Users
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<Users>>
    suspend fun getCompany(): Response<List<Company>>
    suspend fun getAddress(): Response<List<Address>>

}
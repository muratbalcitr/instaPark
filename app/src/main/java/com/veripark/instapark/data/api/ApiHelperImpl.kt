package com.veripark.instapark.data.api

import com.veripark.instapark.data.model.Address
import com.veripark.instapark.data.model.Company
import com.veripark.instapark.data.model.Users
import retrofit2.Response
import javax.inject.Inject


class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): Response<List<Users>> = apiService.getUsers()

    override suspend fun getCompany(): Response<List<Company>> = apiService.getCompany()

    override suspend fun getAddress(): Response<List<Address>> = apiService.getAddress()

}
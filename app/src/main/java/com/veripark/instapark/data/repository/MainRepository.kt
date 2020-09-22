package com.veripark.instapark.data.repository

import com.veripark.instapark.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {


    suspend fun getUsers() =  apiHelper.getUsers()
    suspend fun getCompany() =  apiHelper.getCompany()
    suspend fun getAddress() =  apiHelper.getAddress()


}
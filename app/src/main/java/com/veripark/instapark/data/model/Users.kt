package com.veripark.instapark.data.model

import com.squareup.moshi.Json

data class Users (
    @Json(name = "id")
    val id: Int = 0,

    @Json(name = "name")
    val name: String,

    @Json(name = "username")
    val username: String,

    @Json(name = "email")
    val email: String,

    @Json(name = "address")
    val address: Address,

    @Json(name = "company")
    val company: Company

)
data class Address(

    @Json(name = "street")
    val street: String,

    @Json(name = "suite")
    val suite: String,

    @Json(name = "city")
    val city: String
)

data class Company(
    @Json(name = "name")
    val name: String,

    @Json(name = "catchPhrase")
    val catchPhrase: String,

    @Json(name = "bs")
    val bs: String
)

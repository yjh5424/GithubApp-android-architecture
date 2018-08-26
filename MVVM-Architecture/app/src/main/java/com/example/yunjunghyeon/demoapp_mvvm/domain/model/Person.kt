package com.example.yunjunghyeon.demoapp_mvvm.domain.model
import com.google.gson.annotations.SerializedName

data class Person(
        val id: Long,
        val name: String?,
        val company : String?,
        val login : String,
        val location : String?,
        val email : String?,
        @SerializedName("avatar_url")val avatar: String
)
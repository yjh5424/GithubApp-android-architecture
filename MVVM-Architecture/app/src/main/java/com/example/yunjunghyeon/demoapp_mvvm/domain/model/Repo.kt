package com.example.yunjunghyeon.demoapp_mvvm.domain.model

import com.google.gson.annotations.SerializedName

data class Repo(
        val id: Long,
        val name: String,
        val description: String? = null,
        @SerializedName("stargazers_count") val stargazersCount: Int,
        val language : String?,
        val owner: Person
)
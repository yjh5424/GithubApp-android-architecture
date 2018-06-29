package com.omjoonkim.project.interviewtask.model

import com.google.gson.annotations.SerializedName

data class Repo(
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String?=null,
        @SerializedName("stargazers_count") val stargazersCount : Int,
        @SerializedName("owner") val owner: Person
)
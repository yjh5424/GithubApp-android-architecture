package com.omjoonkim.project.interviewtask.model

import com.google.gson.annotations.SerializedName

data class Owner(
        @SerializedName("id") val id: Long,
        @SerializedName("login") val name: String,
        @SerializedName("avatar_url")val avatar: String
)
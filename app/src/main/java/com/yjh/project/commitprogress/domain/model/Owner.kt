package com.omjoonkim.project.interviewtask.model

import com.google.gson.annotations.SerializedName

data class Owner(
        val id: Long,
        val name: String,
        val company : String?,
        val login : String,
        val location : String?,
        @SerializedName("avatar_url")val avatar: String
)
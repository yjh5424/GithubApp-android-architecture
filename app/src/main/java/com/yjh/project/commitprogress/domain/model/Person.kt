package com.omjoonkim.project.interviewtask.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Person(
        @SerializedName("id") val id: Long,
        @SerializedName("login") val name: String,
        @SerializedName("avatar_url")val avatar: String
)
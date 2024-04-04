package com.example.studentapp.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Student(

    @SerialName("usn")
    val usn: String,

    @SerialName("name")
    val name: String,

    @SerialName("sem")
    val sem: Int
)
package com.example.studentapp.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Expense(
    @SerialName("usn")
    val usn: String,

    @SerialName("tuition")
    val tuition: String,

    @SerialName("txtBook")
    val txtBook: String,

    @SerialName("stationery")
    val stationery:String,

    @SerialName("other")
    val other:String
)
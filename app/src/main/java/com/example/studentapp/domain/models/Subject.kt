package com.example.studentapp.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subject(
    @SerialName("usn")
    val usn: String,

    @SerialName("sb1")
    val sb1: String,

    @SerialName("sb2")
    val sb2: String,

    @SerialName("sb3")
    val sb3: String,

    @SerialName("sb4")
    val sb4: String,

    @SerialName("sb5")
    val sb5: String,

    @SerialName("sb6")
    val sb6: String,

    @SerialName("sb7")
    val sb7: String,

    @SerialName("sb8")
    val sb8: String,

    @SerialName("sb9")
    val sb9: String,

    @SerialName("sb10")
    val sb10: String
)
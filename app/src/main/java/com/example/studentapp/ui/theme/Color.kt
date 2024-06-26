package com.example.studentapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val isLight: @Composable ()->Boolean = {!isSystemInDarkTheme() }

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val titleColor
    @Composable
    get() = if (isLight()) Color.Black else Color.White
val rowBack
    @Composable
    get() = if (isLight()) Color.LightGray else Color.DarkGray

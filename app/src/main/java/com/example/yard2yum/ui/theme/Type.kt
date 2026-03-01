package com.example.yard2yum.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Georgia for Titles
val Georgia = FontFamily.Serif

// Friendly sans-serif for body text
val AppSans = FontFamily.SansSerif

val Typography = Typography(

    // App Title
    headlineLarge = TextStyle(
        fontFamily = Georgia,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        letterSpacing = (-0.5).sp
    ),

    // Section Headers
    titleLarge = TextStyle(
        fontFamily = Georgia,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),

    // Body text
    bodyLarge = TextStyle(
        fontFamily = AppSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),

    // Smaller secondary text
    bodyMedium = TextStyle(
        fontFamily = AppSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    // Buttons
    labelLarge = TextStyle(
        fontFamily = AppSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    )
)
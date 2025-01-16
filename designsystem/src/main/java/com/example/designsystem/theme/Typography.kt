package com.example.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.designsystem.R


val NotoSans = FontFamily(

    Font(R.font.noto_sans_bold, FontWeight.Bold, FontStyle.Normal),

    Font(R.font.noto_sans_medium, FontWeight.Medium, FontStyle.Normal),

    Font(R.font.noto_sans_regular, FontWeight.Normal, FontStyle.Normal)
)


data class CustomTypography internal constructor(

    val bold20: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        lineHeight = 26.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val bold28: TextStyle = TextStyle(
        fontSize = 28.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        lineHeight = 34.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val bold16: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),


    val bold14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        lineHeight = 16.8.sp,
        letterSpacing = 0.4.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val bold12: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        lineHeight = 15.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val regular14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        lineHeight = 21.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val medium14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val medium16: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val medium18: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val medium20: TextStyle = TextStyle(
        fontSize = 24.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val medium12: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        lineHeight = 14.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val regular12: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val regular16: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.4.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val regular10: TextStyle = TextStyle(
        fontSize = 10.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val semibold24: TextStyle = TextStyle(
        fontSize = 24.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 30.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val semibold20: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 26.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val semibold16: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),

    val semibold14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = NotoSans,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 17.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        ),
    ),
)

val LocalTypography = staticCompositionLocalOf { CustomTypography() }









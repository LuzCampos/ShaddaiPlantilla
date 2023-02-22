package com.myprojects.shaddaiapi.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.myprojects.shaddaiapi.R

// Set of Material typography styles to start with

    val circularstdbold = FontFamily(Font(R.font.circularstd_bold))
    val circularstdbook = FontFamily(Font(R.font.circularstd_book))
    val circularstdblack = FontFamily(Font(R.font.circularstd_black))

    val titulo = TextStyle(
    fontFamily = FontFamily(Font(R.font.circularstd_black)),
    fontWeight = FontWeight.W500,
    fontSize = 30.sp
    )
// Other default text styles to override
    val normal = TextStyle(
    fontFamily = FontFamily(Font(R.font.circularstd_book)),
    fontWeight = FontWeight.W500,
    fontSize = 16.sp
    )

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)
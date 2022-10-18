package com.philipademba.takehome.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.philipademba.takehome.R

// Set of Material typography styles to start with
val Typography = Typography(
    FontFamily(Font(R.font.medium)),
    h4 = TextStyle(

        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(

        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    h6 = TextStyle(

        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(

        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(

        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    body1 = TextStyle(

        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(

        fontSize = 14.sp
    ),
    button = TextStyle(

        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(

        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(

        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),
)
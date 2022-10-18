package com.philipademba.takehome.presentation.ui.components

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalFieldSpacing(size: Dp = 16.dp) {
    Spacer(
        modifier = Modifier
            .height(size)
            .focusable(false)
    )

}
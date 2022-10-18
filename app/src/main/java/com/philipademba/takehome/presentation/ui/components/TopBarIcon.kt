package com.philipademba.takehome.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.philipademba.takehome.R

@Composable
fun TopBarIcon(imageVector: ImageVector, onClick: () -> Unit = {}) {
    Icon(
        modifier = Modifier
            .clickable { onClick() }
            .height(50.dp)
            .width(50.dp)
            .padding(start = 16.dp),
        imageVector = imageVector,
        contentDescription = stringResource(id = R.string.go_back_icon),
        tint = Color.White,
    )
}
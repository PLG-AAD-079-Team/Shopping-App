package com.philipademba.takehome.presentation.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppPrimaryButton(text: String, onClicked: () -> Unit, isLoading: Boolean = false) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp)),
        onClick = onClicked
    ) {
        if (!isLoading) {
            Text(text = text, fontSize = 18.sp)
        } else {
            CircularProgressIndicator(color = Color.White, modifier = Modifier.height(25.dp).width(25.dp))
        }

    }
}
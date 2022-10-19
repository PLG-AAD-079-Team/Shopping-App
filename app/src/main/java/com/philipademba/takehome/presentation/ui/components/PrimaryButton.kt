package com.philipademba.takehome.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier.padding(16.dp),
    text: String,
    onClick: () -> Unit,
    imageVector: ImageVector? = null,
    fontColor: Color = Color.Black,
    enabled: Boolean = true,


    ) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)

            .clip(RoundedCornerShape(10.dp))
            .focusable()
    ) {
        Row() {
            Text(
                style = typography.body2,
                color = fontColor,
                text = text,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(end = 8.dp),
            )
            imageVector?.let { Icon(imageVector = it, contentDescription = text, tint = fontColor) }
        }
    }
}

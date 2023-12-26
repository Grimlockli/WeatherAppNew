package com.example.weatherapp.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ComposeText(text: String, textColor: Color = Color.White, fontSize: TextUnit = 10.sp){
    Text(text = text,
        color= textColor,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold)
}
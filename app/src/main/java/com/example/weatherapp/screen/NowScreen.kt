package com.example.weatherapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherapp.model.WeatherModel_old

@Composable
fun NowScreen(now: WeatherModel_old.Result.Now) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val img_url = when(now.text){
            "阴" -> "http://www.moji.com/templets/mojichina/images/weather/weather/w2.png"
            "雷阵雨" -> "http://www.moji.com/templets/mojichina/images/weather/weather/w4.png"
            "多云" -> "http://www.moji.com/templets/mojichina/images/weather/weather/w1.png"
            else -> "http://www.moji.com/templets/mojichina/images/weather/weather/w1.png"
        }

        Image(painter = rememberImagePainter(img_url),
            contentDescription = "",
            modifier = Modifier.size(100.dp))
        ComposeText(text = "${now.temp}", fontSize = 48.sp)
    }

    Surface(
        modifier = Modifier.fillMaxWidth(0.5f),
        color = Color.White,
        shape = RoundedCornerShape(48)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            ComposeText(text = "${now.windDir}", textColor = Color.Black, fontSize = 12.sp)
            ComposeText(text = "${now.windClass}", textColor = Color.Black, fontSize = 12.sp)
            ComposeText(text = "湿度", textColor = Color.Black, fontSize = 12.sp)
            ComposeText(text = "${now.feelsLike}", textColor = Color.Black, fontSize = 12.sp)

        }

    }
}
package com.example.weatherapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherapp.model.WeatherModel_old

@Composable
fun WeatherDaysScreen(forecasts: List<WeatherModel_old.Result.Forecast>) {

    LazyRow{
        items(forecasts){forecast ->
            WeatherItems(forecast)
        }
    }
}

@Composable
fun WeatherItems(forecast: WeatherModel_old.Result.Forecast) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 8.dp, end = 10.dp)) {
        ComposeText(text = "${forecast.week}", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(18.dp))
        val img_url = when(forecast.textDay){
            "阴" -> "http://www.moji.com/templets/mojichina/images/weather/weather/w2.png"
            "雷阵雨" -> "http://www.moji.com/templets/mojichina/images/weather/weather/w4.png"
            "多云" -> "http://www.moji.com/templets/mojichina/images/weather/weather/w1.png"
            else -> "http://www.moji.com/templets/mojichina/images/weather/weather/w1.png"
        }
        Image(painter = rememberImagePainter(img_url),
            contentDescription = "",
            modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.height(2.dp))
        ComposeText(text = "${forecast.high}/${forecast.low}", fontSize = 22.sp)
    }
}
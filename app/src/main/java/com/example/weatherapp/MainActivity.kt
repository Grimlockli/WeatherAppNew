package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.model.WeatherState
import com.example.weatherapp.screen.ComposeText
import com.example.weatherapp.screen.HourlyScreen
import com.example.weatherapp.screen.LocationScreen
import com.example.weatherapp.screen.NowScreen
import com.example.weatherapp.screen.Textfield
import com.example.weatherapp.screen.WeatherDaysScreen
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {

    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    setWeather(weatherViewModel = weatherViewModel)
                    Textfield(weatherViewModel = weatherViewModel)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun setWeather(weatherViewModel: WeatherViewModel){
    when (val result = weatherViewModel.weatherData.value) {
        is WeatherState.Success -> {
            Log.d("--result--", result.weather.toString())
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFBB86FC),
                                Color(0xFF6200EE)
                            )
                        )
                    )
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                HourlyScreen(result.weather.hourly)
                Spacer(modifier = Modifier.height(40.dp))
            }
        }

        is WeatherState.Failure -> {
            Row(modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ComposeText(text = "${result.error}", textColor = Color.Red, fontSize = 18.sp)

            }

        }

        is WeatherState.Loading -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFBB86FC),
                                Color(0xFF6200EE)
                            )
                        )
                    )
            ){
                Surface(onClick = {}, 
                    color = Color.Transparent, 
                    modifier = Modifier.fillMaxWidth(0.6f)
                ){
                    Row(modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(18.dp)
                                .height(18.dp),
                            strokeWidth = 2.dp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        ComposeText(text = "The weather data is loading", textColor = Color.White, fontSize = 16.sp)
                    }
                    
                }
            }

        }
        else -> {
            
        }
    }
}

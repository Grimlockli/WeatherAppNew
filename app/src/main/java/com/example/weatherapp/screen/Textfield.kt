package com.example.weatherapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.weatherapp.viewModel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Textfield(weatherViewModel: WeatherViewModel) {
    // textfield part and search button
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp),
    contentAlignment = Alignment.Center
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            val textValue1 = remember {
                mutableStateOf("")
            }
            val textValue2 = remember {
                mutableStateOf("")
            }

            //Spacer(modifier = Modifier.width(4.dp))

            // longtitude text box
            TextField(
                value = textValue1.value,
                placeholder = { Text(text = "longitude") },
                modifier = Modifier
                    .width(140.dp)
                    .height(60.dp),
                label = { Text(text = "longitude") },
                singleLine = true,
                //leadingIcon = {Icon(Icons.Filled.Info, contentDescription = "")},
                trailingIcon = {
                    if (!textValue1.value.isEmpty()) {
                        IconButton(onClick = { textValue1.value = "" }) {
                            Icon(Icons.Filled.Clear, contentDescription = "")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),

                onValueChange = {
                    textValue1.value = it
                })

            // latitude text box
            TextField(
                value = textValue2.value,
                placeholder = { Text(text = "latitude") },
                modifier = Modifier
                    .width(140.dp)
                    .height(60.dp),
                label = { Text(text = "latitude") },
                singleLine = true,
                //leadingIcon = {Icon(Icons.Filled.Info, contentDescription = "")},
                trailingIcon = {
                    if (!textValue1.value.isEmpty()) {
                        IconButton(onClick = { textValue2.value = "" }) {
                            Icon(Icons.Filled.Clear, contentDescription = "")
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),

                onValueChange = {
                    textValue2.value = it
                })

            // Search weather button
            // Need to make sure longitude and latitude all get float value then we can search

            Button(
                onClick = {
                    if (textValue1.value.isNotBlank() && textValue2.value.isNotBlank()) {
                        weatherViewModel.getWeatherData(
                            longitude = textValue1.value.toDouble(),
                            latitude = textValue2.value.toDouble()
                        )

                    }
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(60.dp)
            ) {
                Text(text = "Search")
            }

        }
    }

}
package com.example.sinwavetosquarewave.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.util.toClosedRange
import androidx.core.util.toRange
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sinwavetosquarewave.canvas.SquareWave

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val frequency = viewModel.frequencyState.collectAsState().value
    val harmonics = viewModel.harmonicsState.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SquareWave(n = harmonics, frequency = frequency)
        FrequencySlider(frequency = frequency, setFrequency = viewModel::setFrequency)
        Spacer(modifier = Modifier.height(12.dp))
        HarmonicSlider(n = harmonics, setHarmonic = viewModel::setHarmonic)
    }
}

@Composable
fun FrequencySlider(
    frequency: Float,
    setFrequency: (Float) -> Unit
) {
    Column {
        Text(text = "Frequency: $frequency")
        Slider(
            value = frequency,
            onValueChange = { setFrequency.invoke(it) },
            valueRange = 0f..100f
        )
    }
}

@Composable
fun HarmonicSlider(
    n: Int,
    setHarmonic: (Float) -> Unit
) {
    Column {
        Text(text = "N: $n")
        Slider(
            value = n.toFloat(),
            onValueChange = { setHarmonic.invoke(it) },
            valueRange = 0f..100f
        )
    }
}
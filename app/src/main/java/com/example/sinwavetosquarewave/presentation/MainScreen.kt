package com.example.sinwavetosquarewave.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
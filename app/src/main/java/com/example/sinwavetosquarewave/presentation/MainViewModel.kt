package com.example.sinwavetosquarewave.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _frequencyState: MutableStateFlow<Float> = MutableStateFlow(0f)
    val frequencyState: StateFlow<Float> = _frequencyState.asStateFlow()

    private val _harmonicsState: MutableStateFlow<Int> = MutableStateFlow(0)
    val harmonicsState: StateFlow<Int> = _harmonicsState.asStateFlow()

    fun setFrequency(frequency: Float) {
        _frequencyState.update { frequency }
    }

    fun setHarmonic(n: Float) {
        _harmonicsState.update {
            if (n.toInt() % 2 == 1 || n.toInt() == 0) n.toInt() else it
        }
    }
}
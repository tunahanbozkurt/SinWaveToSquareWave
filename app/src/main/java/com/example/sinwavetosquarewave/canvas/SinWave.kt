package com.example.sinwavetosquarewave.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.sin

@Composable
fun SinWave(
    frequencyFactor: Float
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val frequency = 2f * frequencyFactor
        val amplitude = canvasHeight / 2f
        val angularFrequency = 2f * Math.PI.toFloat() * frequency

        val startY = canvasHeight / 2f

        val path = Path()
        path.moveTo(0f, startY)

        for (x in 0..canvasWidth.toInt()) {
            val y =
                ((amplitude * sin(angularFrequency * x / canvasWidth.toDouble())).toFloat()) / frequencyFactor
            path.lineTo(x.toFloat(), startY + y)
        }

        drawPath(path, color = Color.Blue, style = Stroke(width = 5f))
    }
}
package com.example.terminal.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.example.terminal.data.model.BarDto

@Composable
fun Terminal(bars: List<BarDto>) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val min = bars.minOf { it.low }
        val max = bars.maxOf { it.low }

        val width = size.width
        val height = size.height

        val barWidth = width / bars.size
        val barHeight = height / (max - min)

        bars.forEachIndexed{index, bar ->
            drawLine(
                color = Color.Blue,
                start =  Offset(barWidth*index, size.height - ((bar.low - min) * barHeight)),
                end =Offset(barWidth*index, size.height - ((bar.high - min) * barHeight)),
            )
        }
    }
}
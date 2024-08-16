package com.example.terminal.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.terminal.data.model.BarDto
import kotlin.math.roundToInt

data class TerminalState(
    val barList: List<BarDto>,
    val visibleBarsCount: Int = 100,
    val terminalWidth: Float = 0f,
    val scrolledBy: Float = 0f
) {

    val barWidth: Float
        get() = terminalWidth / visibleBarsCount

    val visibleBars: List<BarDto>
        get() {
            val startIndex = (scrolledBy / barWidth).roundToInt().coerceAtLeast(0)
            val endIndex = (startIndex + visibleBarsCount).coerceAtMost(barList.size)
            return barList.subList(startIndex, endIndex)
        }


}
@Composable
fun rememberTerminalState(bars: List<BarDto>): MutableState<TerminalState> {
    return rememberSaveable {
        mutableStateOf(TerminalState(bars))
    }
}
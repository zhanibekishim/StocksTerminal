package com.example.terminal.presentation

import com.example.terminal.data.model.BarDto

sealed class TerminalScreenState {
    data object Initial: TerminalScreenState()
    data object Loading: TerminalScreenState()
    data class Content(val timeFrame: TimeFrame,val barList: List<BarDto>) : TerminalScreenState()
}
package com.example.terminal.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.terminal.ui.theme.TerminalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TerminalTheme {
                val viewModel: MainViewModel = viewModel()
                val screenState = viewModel.state.collectAsState()
                when (val currentState = screenState.value) {
                    is TerminalScreenState.Content -> {
                        Terminal(bars = currentState.barList)
                    }

                    is TerminalScreenState.Initial -> {

                    }
                }
            }
        }
    }
}

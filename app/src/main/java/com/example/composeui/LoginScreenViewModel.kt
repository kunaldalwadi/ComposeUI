package com.example.composeui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DataWeTrack())
    val uiState = _uiState.asStateFlow()
    fun updateUsername(usernameInput: String) {
        _uiState.update { DataWeTrack(username = usernameInput) }
    }
}


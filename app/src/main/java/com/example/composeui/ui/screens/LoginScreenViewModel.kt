package com.example.composeui.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composeui.data.DataWeTrack
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DataWeTrack())
    val uiState = _uiState.asStateFlow()

    var nickname by mutableStateOf("")
        private set

    fun updateUsername(usernameInput: String) {
        _uiState.update { DataWeTrack(username = usernameInput) }
    }

    fun updateUsername2(usernameInput: String) {
        _uiState.update { newState ->
            newState.copy(username = "Not you anymore")
        }
    }

    fun updateNickName(nicknameInput: String) {
        nickname = nicknameInput
    }
}


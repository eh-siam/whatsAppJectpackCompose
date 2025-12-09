package com.simec.eventPlanner.ui.auth.registration

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegistrationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(RegistrationUiState())
    val uiState: StateFlow<RegistrationUiState> = _uiState

    fun onNameChange(email: String) {
        _uiState.value = _uiState.value.copy(name = email)
    }
    fun onNumberChange(email: String) {
        _uiState.value = _uiState.value.copy(number = email)
    }
    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _uiState.value = _uiState.value.copy(confirmPassword = confirmPassword)
    }

    fun register() {
        // TODO: Implement registration logic
    }
}

data class RegistrationUiState(
    val name: String = "",
    val number: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
package com.simec.eventPlanner.ui.auth.logIn

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


sealed class LoginResult {
    data class Success(val message: String) : LoginResult()
    data class Error(val error: String) : LoginResult()
}

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    private val _logResult = MutableStateFlow<LoginResult?>(null)
    val logResult: StateFlow<LoginResult?> = _logResult


    private val auth : FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }
    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    private fun validate() : String? {
        val state = _uiState.value
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) return "Invalid Email"
        if(state.password.length<6) return "Password minimum 6 characters"
        return null
    }

    fun login() {
        val error = validate()
        if (error != null) {
            _logResult.value = LoginResult.Error(error)
            return
        }
        val state = _uiState.value
        auth.signInWithEmailAndPassword(state.email, state.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _logResult.value = LoginResult.Success("Login successful")
                } else {
                    _logResult.value = LoginResult.Error("Login failed: ${task.exception?.message}")
                }
            }
    }
}

data class LoginUiState(
    val email: String = "",
    val password: String = ""
)
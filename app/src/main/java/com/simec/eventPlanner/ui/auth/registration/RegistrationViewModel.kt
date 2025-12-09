package com.simec.eventPlanner.ui.auth.registration

import android.R.attr.name
import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegistrationViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    private val _uiState = MutableStateFlow(RegistrationUiState())
    val uiState: StateFlow<RegistrationUiState> = _uiState

    private val _registrationResult = MutableStateFlow<RegistrationResult?>(null)
    val registrationResult: StateFlow<RegistrationResult?> = _registrationResult


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

    private fun validate(): String? {
        val state = _uiState.value

        if (state.name.isBlank()) return "First name required"

        if (state.number.length<10) return "valid number required"

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) return "Invalid Email"

        if (state.password.length<6) return "Password minimum 6 characters"

        if (state.password != state.confirmPassword) return "Password not matched"

        return null

    }
    // Firebase registration
    fun registerUser() {
        val error = validate()
        if (error != null) {
            _registrationResult.value = RegistrationResult.Error(error)
            return
        }

        val state = _uiState.value
        val auth = FirebaseAuth.getInstance()
        val firestore = FirebaseFirestore.getInstance()

        auth.createUserWithEmailAndPassword(state.email, state.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val uid = auth.currentUser?.uid
                    if (uid != null) {
                        val userMap = hashMapOf(
                            "name" to state.name,
                            "number" to state.number,
                            "email" to state.email
                        )

                        firestore.collection("users")
                            .document(uid)
                            .set(userMap)
                            .addOnSuccessListener {
                                _registrationResult.value =
                                    RegistrationResult.Success("Registration successful")
                            }
                            .addOnFailureListener { e ->
                                _registrationResult.value =
                                    RegistrationResult.Error("Registration failed: ${e.message}")
                            }
                    } else {
                        _registrationResult.value =
                            RegistrationResult.Error("Registration failed: UID not found")
                    }
                } else {
                    _registrationResult.value =
                        RegistrationResult.Error("Registration failed: ${task.exception?.message}")
                }
            }
    }

}

data class RegistrationUiState(
    val name: String = "",
    val number: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)


sealed class RegistrationResult {
    data class Success(val message: String): RegistrationResult()
    data class Error(val message: String): RegistrationResult()
}
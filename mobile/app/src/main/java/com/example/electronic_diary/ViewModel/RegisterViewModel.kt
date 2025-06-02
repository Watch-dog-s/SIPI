package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronic_diary.api.Remote.RegisterRequest
import com.example.electronic_diary.api.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {
    private val _login=MutableStateFlow("")
    private val _email=MutableStateFlow("")
    private val _password=MutableStateFlow("")
    private val _registerSuccess= MutableStateFlow(false)

    val password: StateFlow<String> =_password
    val email: StateFlow<String> =_email
    val login: StateFlow<String> =_login
    val registerSuccess: StateFlow<Boolean> =_registerSuccess

    fun changeRegisterStatus() {
        _registerSuccess.value = !_registerSuccess.value
    }

    fun ChangeLogin(newLogin:String){
        _login.value=newLogin
    }

    fun ChangeEmail(newEmail:String){
        _login.value=newEmail
    }

    fun ChangePassword(newPassword:String){
        _password.value=newPassword
    }

    fun letRegister() {
        viewModelScope.launch {

            val registerRequest = RegisterRequest(login.value, email.value, password.value)
            val response = RetrofitClient.apiService.register(registerRequest)

            println(response)
        }
    }
}
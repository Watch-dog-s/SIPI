package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronic_diary.api.dto.LoginRequest
import com.example.electronic_diary.api.remote.loginUser
import com.example.electronic_diary.api.remote.registerUser
import com.example.electronic_diary.cache.TokenCache
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {

    private val _login = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _loginSuccess = MutableStateFlow(false)

    val login: StateFlow<String> =_login
    val password: StateFlow<String> =_password
    val loginSuccess: StateFlow<Boolean> =_loginSuccess

    fun ChangeLogin(newLogin:String){
        _login.value=newLogin
    }

    fun ChangePassword(newpassword:String){
        _password.value=newpassword
    }

    fun changeLoginState()
    {
        _loginSuccess.value = !_loginSuccess.value
    }

    fun login()
    {
        val loginRequest = LoginRequest(login.value, password.value)

        viewModelScope.launch {
            try {
                val result = loginUser(loginRequest)
                if(result.isSuccess){
                    TokenCache.token.add(result.toString())
                    changeLoginState()
                    println(result.toString())
                } else {
                    println(result)
                }

            } catch (e : Exception) {
                println(e.localizedMessage)
            }
        }
    }
}
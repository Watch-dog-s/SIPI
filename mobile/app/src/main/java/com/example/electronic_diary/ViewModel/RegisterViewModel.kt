package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electronic_diary.api.dto.RegisterRequest
import com.example.electronic_diary.api.remote.registerUser
import com.example.electronic_diary.cache.TokenCache
import com.example.electronic_diary.screens.Password_recovery_Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {
    private val _login=MutableStateFlow("")
    private val _email=MutableStateFlow("")
    private val _password=MutableStateFlow("")
    private val _registerSuccess= MutableStateFlow(false)

    val login: StateFlow<String> =_login
    val email: StateFlow<String> =_email
    val password: StateFlow<String> =_password
    val registerSuccess: StateFlow<Boolean> =_registerSuccess

    fun changeRegisterState() {_registerSuccess.value = !_registerSuccess.value}

    fun ChangeLogin(newlogin:String){_login.value=newlogin}

    fun ChangeEmail(newEmail:String){_email.value=newEmail}

    fun ChangePassword(newpassword:String){_password.value=newpassword}

    fun register()
    {
        if(!login.value.isEmpty() && !email.value.isEmpty() && !password.value.isEmpty()){
            val registerRequest : RegisterRequest = RegisterRequest(login.value, email.value, password.value)

            viewModelScope.launch {

                try {
                    val result = registerUser(registerRequest)
                    if(result.isSuccess){
                        changeRegisterState()
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
}
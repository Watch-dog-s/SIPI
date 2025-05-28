package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel:ViewModel() {
    private val _login= MutableStateFlow("")
    val login: StateFlow<String> =_login

    private val _password= MutableStateFlow("")
    val password: StateFlow<String> =_password

    private val _loginsuccess= MutableStateFlow(false)
    val loginsuccess: StateFlow<Boolean> =_loginsuccess.asStateFlow()

    fun ChangeLogin(newlogin:String){
        _login.value=newlogin
    }

    fun ChangePassword(newpassword:String){
        _password.value=newpassword
    }

    fun changeTrue(){_loginsuccess.value=true}

    fun changeFalse(){_loginsuccess.value=false}
}
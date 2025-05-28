package com.example.electronic_diary.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel: ViewModel() {
    private val _login=MutableStateFlow("")
    val login: StateFlow<String> =_login

    private val _password=MutableStateFlow("")
    val password: StateFlow<String> =_password

    private val _registersuccess= MutableStateFlow(false)
    val registersuccess: StateFlow<Boolean> =_registersuccess.asStateFlow()

    fun changeTrue(){_registersuccess.value=true}

    fun changeFalse(){_registersuccess.value=false}

    fun ChangeLogin(newlogin:String){_login.value=newlogin}

    fun ChangePassword(newpassword:String){_password.value=newpassword}
}
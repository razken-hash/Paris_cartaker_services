package com.example.paris_cartaker_services.views.auth.views

import android.content.Context
import android.text.BoringLayout
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel() : ViewModel() {

    var email: String by mutableStateOf("ka_kenniche@esi.dz")
    var password: String by mutableStateOf("12345678")
    var rememberMe: Boolean by mutableStateOf(false)

    var authStatus by mutableStateOf(false)
    var userId by mutableStateOf(-1)

    fun login() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
            }
        }
    }

    fun register() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
            }
        }
    }

    class Factory() :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AuthViewModel() as T
        }
    }

}
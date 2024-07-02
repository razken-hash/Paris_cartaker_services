package com.example.paris_cartaker_services.views.router

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paris_cartaker_services.views.auth.views.AuthView
import com.example.paris_cartaker_services.views.auth.views.AuthViewModel
import com.example.paris_cartaker_services.views.auth.views.LoginView
import com.example.paris_cartaker_services.views.auth.views.RegisterView
import com.example.paris_cartaker_services.views.auth.views.forgot_password.ForgotPasswordView
import com.example.paris_cartaker_services.views.auth.views.forgot_password.OTPScreen
import com.example.paris_cartaker_services.views.auth.views.forgot_password.ResetPasswordView
import com.example.paris_cartaker_services.views.on_boarding.views.OnBoardingView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationHost(
    authViewModel: AuthViewModel,
    navController: NavHostController,
    pref: SharedPreferences
) {
    val userId = pref.getInt("userId",-1);
    val startScreen = if (userId == -1) Router.OnBoardingScreen.route else Router.ParkirNavScreen.route

    NavHost(navController = navController, startDestination = startScreen) {
        composable(route = Router.OnBoardingScreen.route) {
            OnBoardingView(navController = navController)
        }
        composable(route = Router.AuthScreen.route) {
            AuthView(navController = navController, authViewModel = authViewModel)
        }
        composable(route = Router.RegisterScreen.route) {
            RegisterView(navController = navController, authViewModel = authViewModel)
        }
        composable(route = Router.LoginScreen.route) {
            LoginView(navController = navController, authViewModel = authViewModel)
        }
        composable(route = Router.ForgotPasswordScreen.route) {
            ForgotPasswordView(navController = navController)
        }
        composable(route = Router.OTPScreen.route) {
            OTPScreen(navController = navController)
        }
        composable(route = Router.ResetPasswordScreen.route) {
            ResetPasswordView(navController = navController)
        }
    }
}
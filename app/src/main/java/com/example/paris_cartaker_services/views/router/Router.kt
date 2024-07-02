package com.example.paris_cartaker_services.views.router

sealed class Router(val route: String) {
    object OnBoardingScreen: Router("/on_boarding")
    object AuthScreen: Router("/auth")
    object RegisterScreen: Router("/auth/register")
    object LoginScreen: Router("/auth/login")
    object ForgotPasswordScreen: Router("/auth/forgot_password")
    object OTPScreen: Router("/auth/otp")
    object ResetPasswordScreen: Router("/auth/reset_password")
    object ParkirNavScreen: Router("/nav")
}
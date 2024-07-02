package com.example.paris_cartaker_services.views.auth.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.paris_cartaker_services.R
import com.example.paris_cartaker_services.views.auth.views.composables.OAuthSection
import com.example.paris_cartaker_services.views.router.Router
import com.example.paris_cartaker_services.views.ui.composables.BackUpBar
import com.example.paris_cartaker_services.views.ui.composables.PCSButton
import com.example.paris_cartaker_services.views.ui.composables.PCSCheckBox
import com.example.paris_cartaker_services.views.ui.composables.PCSField
import com.example.paris_cartaker_services.views.ui.theme.grey
import com.example.paris_cartaker_services.views.ui.theme.primary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(navController: NavHostController, authViewModel: AuthViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        BackUpBar(title = "", navController = navController)

        Text(
            text = "Se connecter à\nvotre compte",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Left,
        )

        PCSField(
            value = authViewModel.email,
            onValueChange = {
                authViewModel.email = it
            },
            placeHolderText = "Email",
            leadingIconId = R.drawable.message_bold,
        )

        PCSField(
            value = authViewModel.password,
            onValueChange = {
                authViewModel.password = it
            },
            placeHolderText = "Mot de passe",
            leadingIconId = R.drawable.lock_bold,
            trailingIconId = R.drawable.show_outline,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PCSCheckBox(value = authViewModel.rememberMe) {
                authViewModel.rememberMe = !authViewModel.rememberMe
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Me souvenir")
        }


        PCSButton(label = "Se connecter", onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                authViewModel.login()
            }
        })

        Text(
            text = "Mot de passe oublié?",
            color = primary,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    navController.navigate(Router.ForgotPasswordScreen.route)
                }
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Divider(
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "  ou bien  ",
                style = MaterialTheme.typography.bodyLarge,
            )
            Divider(
                modifier = Modifier.weight(1f)
            )
        }

        OAuthSection(viewMode = 1, navController = navController, authViewModel = authViewModel)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Je n'ai pas de compte? ",
                color = grey,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Je m'inscrire",
                color = primary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                    navController.navigate(Router.RegisterScreen.route)
                }
            )
        }
        Box {}

        if (authViewModel.authStatus) {
            LaunchedEffect(Unit) {
                navController.navigate(Router.ParkirNavScreen.route)
            }
        }
    }
}
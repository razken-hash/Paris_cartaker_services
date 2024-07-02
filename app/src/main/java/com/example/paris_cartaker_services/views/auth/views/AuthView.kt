package com.example.paris_cartaker_services.views.auth.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.paris_cartaker_services.views.auth.views.composables.OAuthSection
import com.example.paris_cartaker_services.views.router.Router
import com.example.paris_cartaker_services.views.ui.composables.BackUpBar
import com.example.paris_cartaker_services.views.ui.composables.PCSButton
import com.example.paris_cartaker_services.views.ui.theme.primary

@Composable
fun AuthView(navController: NavHostController, authViewModel: AuthViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        BackUpBar(title = "", navController = navController)

        Text(
            text = "Laissez-vous\ndécouvrir",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        OAuthSection(viewMode = 0, navController = navController, authViewModel = authViewModel)

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

        PCSButton(label = "Se connecter", onClick = {
            navController.navigate(Router.LoginScreen.route)
        })

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Je n'ai pas de compte? ",
//                color = grey,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Je m'inscrire",
                color = primary,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    navController.navigate(Router.RegisterScreen.route)
                }
            )
        }
        Box {}
    }
}
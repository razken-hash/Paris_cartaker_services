package com.example.paris_cartaker_services.views.auth.views.forgot_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.paris_cartaker_services.R
import com.example.paris_cartaker_services.views.router.Router
import com.example.paris_cartaker_services.views.ui.composables.BackUpBar
import com.example.paris_cartaker_services.views.ui.composables.PCSButton
import com.example.paris_cartaker_services.views.ui.composables.PCSCheckBox
import com.example.paris_cartaker_services.views.ui.composables.PCSField
import com.example.paris_cartaker_services.views.ui.theme.primary
import com.example.paris_cartaker_services.views.ui.theme.white

@Composable
fun ResetPasswordView(navController: NavHostController) {

    var password by remember {
        mutableStateOf("")
    }

    var confirmationPassword by remember {
        mutableStateOf("")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    var success by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        BackUpBar(title = "Create New Password", navController = navController)

        Image(
            painter = painterResource(id = R.drawable.password),
            contentDescription = "Reset Password",
            modifier = Modifier
                .height(250.dp)
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Create your new password",
            style = MaterialTheme.typography.bodyLarge,
        )

        PCSField(
            value = password,
            onValueChange = {
                password = it
            },
            placeHolderText = "Password",
            leadingIconId = R.drawable.lock_bold,
            trailingIconId = R.drawable.show_outline,
        )

        PCSField(
            value = confirmationPassword,
            onValueChange = {
                confirmationPassword = it
            },
            placeHolderText = "Confirmation Password",
            leadingIconId = R.drawable.lock_bold,
            trailingIconId = R.drawable.show_outline,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PCSCheckBox(value = rememberMe) {
                rememberMe = !rememberMe
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Remember me")
        }

        PCSButton(label = "Continue", onClick = {
            success = true
        })

        if (success) {
            ResetPasswordSuccessBox {
                navController.navigate(Router.ParkirNavScreen.route)
            }
        }

    }
}

@Composable
fun ResetPasswordSuccessBox(
    onClick: () -> Unit,
) {
    AlertDialog(
        containerColor = white,
        onDismissRequest = {},
        tonalElevation = 100.dp,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .background(primary)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tick_square_bold),
                        contentDescription = "Success",
                        colorFilter = ColorFilter.tint(
                            white
                        ),
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)

                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Congratulations!",
                    style = MaterialTheme.typography.displaySmall,
                    color = primary,
                )
                Text(
                    text = "Your account is ready to use",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        },
        confirmButton = {
            PCSButton(label = "Go to Home", onClick = onClick)
        }
    )
}
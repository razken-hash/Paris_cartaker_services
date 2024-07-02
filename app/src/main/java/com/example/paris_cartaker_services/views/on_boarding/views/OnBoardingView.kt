package com.example.paris_cartaker_services.views.on_boarding.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.paris_cartaker_services.views.ui.composables.PCSButton
import com.example.paris_cartaker_services.views.on_boarding.model.OnBoardingItem
import com.example.paris_cartaker_services.views.on_boarding.views.composables.IndicatorsBox
import com.example.paris_cartaker_services.views.on_boarding.views.composables.OnBoardingBox
import com.example.paris_cartaker_services.views.router.Router
import com.example.paris_cartaker_services.views.ui.theme.primary
import com.example.paris_cartaker_services.views.ui.theme.primary1A

@Composable
fun OnBoardingView(navController: NavHostController) {
    val onBoardingItems: List<OnBoardingItem> = OnBoardingItem.onBoardingItems;
    var selectedItem = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Box(modifier = Modifier.weight(7f)) {

            OnBoardingBox(onBoardingItem = onBoardingItems[selectedItem.value])

        }
        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier.weight(3f),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            IndicatorsBox(
                nbIndicators = onBoardingItems.size,
                selectedIndicator = selectedItem.value
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                // Next Button
                PCSButton(
                    label = "Next",
                    onClick = {
                        if (selectedItem.value < 2) {
                            selectedItem.value = selectedItem.value + 1;
                        } else {
                            navController.navigate(Router.AuthScreen.route)
                        }
                    },
                )

                // Skip Button
                PCSButton(
                    label = "Skip",
                    onClick = {
                        navController.navigate(Router.AuthScreen.route)
                    },
                    labelColor = primary,
                    bgColor = primary1A,
                )
            }
        }
    }
}

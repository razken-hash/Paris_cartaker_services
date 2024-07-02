package com.example.paris_cartaker_services.views.ui.composables

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.paris_cartaker_services.views.ui.theme.grey02
import com.example.paris_cartaker_services.views.ui.theme.primary
import com.example.paris_cartaker_services.views.ui.theme.white

@Composable
fun PCSSwitch(
    value: Boolean,
    onCheckChange: (Boolean) -> Unit,
) {
    var value by remember {
        mutableStateOf(value)
    }

    Switch(
        checked = value,
        onCheckedChange = {
            onCheckChange
            value = !value
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = white,
            checkedTrackColor = primary,
            checkedBorderColor = primary,
            checkedIconColor = primary,
            uncheckedThumbColor = white,
            uncheckedTrackColor = grey02,
            uncheckedBorderColor = grey02,
            uncheckedIconColor = grey02,
        )
    )
}
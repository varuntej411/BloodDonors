package com.blood.donors.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingScreen(
    navigateToOnBoardScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "ONBOARDING",
            Modifier.clickable {
                navigateToOnBoardScreen.invoke()
            })
    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {

    OnBoardingScreen {

    }

}
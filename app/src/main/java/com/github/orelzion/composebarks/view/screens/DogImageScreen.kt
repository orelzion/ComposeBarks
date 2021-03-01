package com.github.orelzion.composebarks.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DogImageScreen(imageUrl: String?) {

}

@Preview
@Composable
fun PreviewImageScreen() {
    DogImageScreen("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg")
}
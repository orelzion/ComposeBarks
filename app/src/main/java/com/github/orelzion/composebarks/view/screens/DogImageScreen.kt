package com.github.orelzion.composebarks.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter

@Composable
fun DogImageScreen(imageUrl: String?) {
    imageUrl?.let {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = "A dog image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun PreviewImageScreen() {
    DogImageScreen("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg")
}
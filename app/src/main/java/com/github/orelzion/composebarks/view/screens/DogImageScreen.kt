package com.github.orelzion.composebarks.view.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun DogImageScreen(imageUrl: String?) {
    imageUrl?.let {
        GlideImage(
            modifier = Modifier.fillMaxSize(),
            data = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun PreviewImageScreen() {
    DogImageScreen("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg")
}
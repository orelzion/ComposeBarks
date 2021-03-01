package com.github.orelzion.composebarks.view

import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.github.orelzion.composebarks.view.Destinations.DogsImage

object Destinations {
    const val Home = "home"
    const val DogsImage = "dog-image"

    object DogImageArgs {
        const val ImageUrl = "imageUrl"
    }
}

class Actions(val navController: NavController) {
    val openFullImage: (String) -> Unit = { url ->
        navController.navigate("$DogsImage/$url")
    }

    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}
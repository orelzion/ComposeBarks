package com.github.orelzion.composebarks.view

import androidx.navigation.NavController
import com.github.orelzion.composebarks.view.Destinations.DogsImage
import java.net.URLEncoder

object Destinations {
    const val Home = "home"
    const val DogsImage = "dog-image"

    object DogImageArgs {
        const val ImageUrl = "imageUrl"
    }
}

class Actions(private val navController: NavController) {
    val openFullImage: (String) -> Unit = { url ->
        val urlEncoded = URLEncoder.encode(url, "utf-8")
        navController.navigate("$DogsImage/${urlEncoded}")
    }

    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}
package com.github.orelzion.composebarks

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.orelzion.composebarks.ui.theme.ComposeBarksTheme
import com.github.orelzion.composebarks.view.Actions
import com.github.orelzion.composebarks.view.Destinations
import com.github.orelzion.composebarks.view.screens.DogImageScreen
import com.github.orelzion.composebarks.view.screens.DogListScreen
import com.github.orelzion.composebarks.viewmodel.DogsListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Workaround. koin compose library is not stable yet
    private val dogsListViewModel: DogsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeBarksTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val actions = remember(navController) { Actions(navController) }

                    NavHost(navController, startDestination = Destinations.Home) {
                        composable(Destinations.Home)
                        { DogListScreen(dogsListViewModel, actions.openFullImage) }
                        composable("${Destinations.DogsImage}/{${Destinations.DogImageArgs.ImageUrl}}")
                        { DogImageScreen(it.arguments?.getString(Destinations.DogImageArgs.ImageUrl)) }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBarksTheme {

    }
}
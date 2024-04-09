package codeisgroup.sananismayilov.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import codeisgroup.sananismayilov.movieapp.presentation.moviedetailscreen.view.MovieDetail
import codeisgroup.sananismayilov.movieapp.presentation.moviescreen.view.MoviesScreen
import codeisgroup.sananismayilov.movieapp.presentation.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Navigation()
            }

        }
    }
}


@Composable
fun Navigation() {
    val navcontroller = rememberNavController()
    NavHost(navController = navcontroller, startDestination = "MovieScreen") {
        composable(route = "MovieScreen") {
            MoviesScreen(navController = navcontroller)
        }

        composable(route = "MovieDetailScreen/{imdbId}", arguments = listOf(
            navArgument("imdbId") { type = NavType.StringType }
        )) {
            val imdbId = it.arguments?.getString("imdbId")
            MovieDetail(imdbId = imdbId!!)
        }
    }


}


@Preview(showBackground = true)
@Composable
fun SimpleComposablePreview() {
    MoviesScreen(navController = rememberNavController())
}



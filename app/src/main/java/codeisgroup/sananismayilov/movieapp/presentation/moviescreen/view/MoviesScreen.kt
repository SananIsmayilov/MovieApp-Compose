package codeisgroup.sananismayilov.movieapp.presentation.moviescreen.view

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import codeisgroup.sananismayilov.movieapp.presentation.moviescreen.MovieViewModel
import codeisgroup.sananismayilov.movieapp.util.Constants


@Composable
fun MoviesScreen(navController: NavController, viewmodel: MovieViewModel = hiltViewModel()) {
    val state = viewmodel.state.value
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize(),
    ) {
        Column {
            MovieSearchBar(modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
                hint = "Batman",
                onSearch =
                {
                    viewmodel.getMovies(it)
                })

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movieList) {
                    moviesRow(movie = it) { movie ->
                        navController.navigate("MovieDetailScreen/${movie.imdbID}")
                    }
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error, modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    modifier: Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        TextField(
            value = text,
            keyboardActions = KeyboardActions(onDone = {
                onSearch(text)
            }),
            onValueChange = {
                text = it
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.Red, shape = RoundedCornerShape(12.dp))
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                }, colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 15.dp)
            )
        }
    }
}







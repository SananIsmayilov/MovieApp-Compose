package codeisgroup.sananismayilov.movieapp.presentation.moviedetailscreen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import codeisgroup.sananismayilov.movieapp.domain.model.MoviesDetailModel
import codeisgroup.sananismayilov.movieapp.presentation.moviedetailscreen.MovieDetailViewModel
import coil.compose.rememberImagePainter

@Composable
fun MovieDetail(imdbId: String, viewDetailModel: MovieDetailViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewDetailModel.getMovieDetail(imdbId)
    }
    val state = viewDetailModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        state.movieDetailModel?.let {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberImagePainter(data = state.movieDetailModel!!.Poster),
                    contentDescription = state.movieDetailModel!!.Poster,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                textShow(stringParametr = state.movieDetailModel!!.title)
                textShow(stringParametr = state.movieDetailModel!!.Language)
                textShow(stringParametr = state.movieDetailModel!!.Actors)
                textShow(stringParametr = state.movieDetailModel!!.Director)
                textShow(stringParametr = state.movieDetailModel!!.Genre)
                textShow(stringParametr = state.movieDetailModel!!.Released)

            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error, modifier = Modifier
                    .fillMaxWidth(),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}

@Composable
fun textShow(stringParametr: String) {
    Text(
        text = stringParametr,
        color = Color.White,
        fontSize = 25.sp,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp),
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(15.dp))
}

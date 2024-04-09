package codeisgroup.sananismayilov.movieapp.presentation.moviescreen.view

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import codeisgroup.sananismayilov.movieapp.R
import codeisgroup.sananismayilov.movieapp.domain.model.MovieModel
import coil.compose.rememberImagePainter

@Composable
fun moviesRow(movie: MovieModel, onItemClick: (MovieModel) -> Unit) {

    Card(
        modifier = Modifier
            .padding(5.dp)
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maincard)),
        shape = RoundedCornerShape(20.dp)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(movie)
            }) {
            Image(
                painter = rememberImagePainter(data = movie.Poster),
                contentDescription = movie.Poster,
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RectangleShape)
                    .width(200.dp)
                    .height(180.dp)
            )

            Text(
                text = movie.Title,
                color = Color.White,
                fontSize = 25.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            )

        }
    }

}
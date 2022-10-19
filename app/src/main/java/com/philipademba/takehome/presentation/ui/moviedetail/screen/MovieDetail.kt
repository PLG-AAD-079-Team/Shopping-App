package com.philipademba.takehome.presentation.ui.moviedetail.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.philipademba.takehome.R
import com.philipademba.takehome.data.models.database.entities.MovieDetail
import java.time.Duration

@Composable
fun MovieDetail(movie: MovieDetail) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            Modifier

        ) {
            if (movie.title.isBlank()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No data", color = Color.Black)
                }

            } else {
                MovieDetailHeader(movie)
            }

        }

        Column(Modifier.background(color = Color.Gray)) {

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = movie.title,
                style = MaterialTheme.typography.h5,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Release Date: ${movie.releaseDate}",
                style = MaterialTheme.typography.body1,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

        }
        Text(
            text = movie.overview,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Genre: ")
            }
            append(movie.genres.joinToString { it.name ?: "" })
        }, color = Color.DarkGray, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Watch Time: ")
            }

            if (movie.runtime != null) {
                if (Duration.ofMinutes(movie.runtime.toLong()).toHours() > 0) {
                    append(Duration.ofMinutes(movie.runtime.toLong()).toHours().toString())
                    append("Hr ")
                }

                append(Duration.ofMinutes(movie.runtime.toLong() % 60).toMinutes().toString())
                append("Mins")
            }


        }, color = Color.DarkGray, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
    }
}

@Composable
private fun MovieDetailHeader(
    movie: MovieDetail
) {

    Column {
        val context = LocalContext.current
        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.backdropPath}"
        val placeholderImage = R.drawable.movie

        val imageRequest = ImageRequest.Builder(context)
            .data(imageUrl)
            .placeholder(placeholderImage)
            .error(placeholderImage)
            .fallback(placeholderImage)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build()

        AsyncImage(
            model = imageRequest,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            contentDescription = stringResource(
                id = R.string.movie_poster_content_description,
                movie.title
            ),
            contentScale = ContentScale.FillBounds,
            imageLoader = context.imageLoader,
        )

    }
}
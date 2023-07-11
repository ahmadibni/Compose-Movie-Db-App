package com.capstone.submissioncompose.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.capstone.submissioncompose.model.Movies

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    title: String,
) {
    val movie = Movies.getMovies(context).first {
        it.title == title
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = movie.photo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
        Text(
            text = movie.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = movie.year,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Light
            ),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(
                horizontal =  16.dp,
                vertical = 8.dp
            )
        )
        Text(
            text = movie.synopsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(16.dp)
        )

    }
}
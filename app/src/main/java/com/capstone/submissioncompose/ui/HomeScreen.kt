package com.capstone.submissioncompose.ui

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.capstone.submissioncompose.model.Movies

@Composable
fun HomeScreen(
    context: Context = LocalContext.current,
    navigateToDetail: (String) -> Unit
){
    Box {
        LazyColumn {
            items(Movies.getMovies(context), key = { it.title }) { movie ->
                MovieListItem(
                    title = movie.title,
                    photo = movie.photo,
                    year = movie.year,
                    modifier = Modifier
                        .clickable {
                            navigateToDetail(movie.title)
                        }
                )
            }
        }
    }
}
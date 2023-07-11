package com.capstone.submissioncompose.model

import android.content.Context
import com.capstone.submissioncompose.R

object Movies {
    fun getMovies(context: Context): ArrayList<Movie> {
        val dataTitle = context.resources.getStringArray(R.array.data_title)
        val dataYear = context.resources.getStringArray(R.array.data_year)
        val dataSynopsis = context.resources.getStringArray(R.array.data_synopsis)
        val dataPhoto = context.resources.obtainTypedArray(R.array.data_photo)
        val listMovie = ArrayList<Movie>()

        for (i in dataTitle.indices) {
            val movie = Movie(
                dataTitle[i],
                dataYear[i],
                dataPhoto.getResourceId(i, -1),
                dataSynopsis[i]
            )
            listMovie.add(movie)
        }
        return listMovie
    }
}
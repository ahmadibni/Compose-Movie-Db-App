package com.capstone.submissioncompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MovieListItem(
    title: String,
    photo: Int,
    year: String,
    modifier: Modifier,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .shadow(1.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Image(
                painter = painterResource(id = photo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .padding(8.dp)
                    .size(60.dp)
            )
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .wrapContentHeight()
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                )
                Text(
                    text = year,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                )
            }
        }
    }
}
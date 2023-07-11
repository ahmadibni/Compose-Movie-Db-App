package com.capstone.submissioncompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.submissioncompose.R
import com.capstone.submissioncompose.ui.theme.SubmissionComposeTheme

@Composable
fun ProfileScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(32.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ibni2),
            contentDescription = "my_photo",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Ahmad Ibni Abdillah",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = "ahmadibni007@gmail.com",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier.padding(
                horizontal = 46.dp,
                vertical = 8.dp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPrefiew(){
    SubmissionComposeTheme {
        ProfileScreen()
    }
}
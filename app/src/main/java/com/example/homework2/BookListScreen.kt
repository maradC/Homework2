package com.example.homework2

import android.widget.Button
import android.widget.MediaController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn


class BookListScreen( modifier: Modifier = Modifier) {

    @Composable
    fun Heading(heading: String) {
        Text(
            text = heading,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            softWrap = false,
            style = MaterialTheme.typography.headlineMedium
        )
    }

    @Composable
    fun NormText(text: String) {
        Text(
            text = text,
            color = Color.Magenta,
            style = MaterialTheme.typography.bodyLarge
        )
    }


    @Composable
    fun DisplayButtons() {
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            shadowElevation = 30.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Heading("Student Schedule")
                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(onClick = {

                    }, modifier = Modifier.weight(1f)) {
                        Text(text = "Stats Screen")
                    }

                    Spacer(modifier = Modifier.width(8.dp))


                    Button(onClick = {

                    }, modifier = Modifier.weight(1f)) {
                        Text(text = "App Info")
                    }
                }
            }
        }
    }
}


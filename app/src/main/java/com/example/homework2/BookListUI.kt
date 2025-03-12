package com.example.homework2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun BookListUI(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel = viewModel { BookListViewModel(MyApplication.x) }
    val books = viewModel.getBooks()

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        ButtonsSection(navController)
        Spacer(modifier = Modifier.height(16.dp))
        BookListSection(books)
    }
}

@Composable
private fun ButtonsSection(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.navigate("statistics") },
            ) {
                Text("Statistics Screen")
            }

            Spacer(modifier = Modifier.width(7.dp))

            Button(
                onClick = { navController.navigate("appinfo") },
            ) {
                Text("App Info Screen")
            }
        }
    }
}

@Composable
fun BookListSection(books: List<Book>) {
    Surface(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Heading("Book List")

            Spacer(modifier = Modifier.height(16.dp))

            BookList(books)
        }
    }
}

@Composable
private fun BookList(books: List<Book>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(books) { book ->
            BookItem(book)
        }
    }
}

@Composable
private fun BookItem(book: Book) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = book.title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = book.genre.trim(),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Magenta
        )
        Text(
            text = "$${String.format("%.2f", book.price)}",
            color = Color.Magenta,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun Heading(heading: String) {
    Text(
        text = heading,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        softWrap = false,
        style = MaterialTheme.typography.headlineMedium
    )
}
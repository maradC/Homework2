package com.example.homework2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BookStatisticsUI(modifier: Modifier = Modifier) {

    val viewModel = viewModel { StatsScreenVM(MyApplication.x) }
    val stats = viewModel.getGenreStats()

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        StatisticsSection(stats)
    }
}

@Composable
private fun StatisticsSection(stats: Map<String, Double>) {
    Surface(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),

        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Heading("Book Statistics")

            Spacer(modifier = Modifier.height(4.dp))

            StatisticsList(stats)
        }
    }
}

@Composable
private fun StatisticsList(stats: Map<String, Double>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(stats.entries.toList()) { entry ->
            StatisticsItem(entry.key, entry.value)
        }
    }
}

@Composable
private fun StatisticsItem(category: String, price: Double) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = category+": $${String.format("%.2f", price)}",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Magenta
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



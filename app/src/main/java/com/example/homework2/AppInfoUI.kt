package com.example.homework2

import androidx.compose.foundation.layout.*
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
fun AppInfoUI(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel = viewModel { AppInfoVM(MyApplication.x) }
    val name = viewModel.getName()
    val dev = viewModel.getDevName()
    val vers = viewModel.getVersion()

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Surface(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            shadowElevation = 30.dp
        ) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(10.dp)
            ) {
                Text("Back to Book List")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        AppInfoSection(name, dev, vers)
    }
}

@Composable
private fun AppInfoSection(appName: String, devName: String, version: String) {
    Surface(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "App Info",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                softWrap = false,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Name: $appName",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Magenta
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Developer: $devName",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Magenta
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Version: $version",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Magenta
            )
        }
    }
}
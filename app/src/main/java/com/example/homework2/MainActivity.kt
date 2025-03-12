package com.example.homework2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.homework2.ui.theme.Homework2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Homework2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Nav(Modifier.padding(innerPadding))
                }
            }
        }
    }
}



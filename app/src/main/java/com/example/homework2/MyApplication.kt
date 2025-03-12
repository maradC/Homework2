package com.example.homework2

import android.app.Application
import com.example.homework2.BookRepository

class MyApplication : Application(){
    companion object {
        lateinit var x: BookRepository
    }
    override fun onCreate() {
        super.onCreate()
// Perform initialization tasks here
// Setup global resources, libraries, etc.
        x = BookRepository()
    }
}

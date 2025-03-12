package com.example.homework2

import androidx.lifecycle.ViewModel

class BookListViewModel(private var repository: BookRepository):ViewModel() {
    fun getBooks(): List<Book>{
        return repository.getBooks()
    }
}
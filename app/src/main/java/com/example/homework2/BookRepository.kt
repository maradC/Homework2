package com.example.homework2

class BookRepository {

    private val appName: String
    private val appDeveloperName: String
    private val appVersion: String
    private val bookList: MutableList<Book>


    init {
        appName = "Book.io"
        appDeveloperName = "Chris Maradiaga"
        appVersion = "3.9.2"

        // Hardcoding a list of books
        bookList = mutableListOf(
            Book("Joy Buolamwini Biography: Championing Humanity in the Age of AI ", "Biography ", 16.96),
            Book("Ada Lovelace: A Life from Beginning to End", "Biography ", 9.99),
            Book("Alan Turing: The Enigma ", "Biography ", 8.50),
            Book("Trust ", "Science Fiction ", 10.17),
            Book("Dark Matter ", "Science Fiction ", 9.16),
            Book("The Midnight Library ", "Science Fiction ", 9.54) ,
            Book("Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones ", "Self-help", 15.00),
            Book("Happiness is Choice ", "Self-help ", 15.00),
            Book("Get Out of Your Head: Stopping the Spiral of Toxic Thoughts ","Self-help", 13.73)


        )
    }

    fun getAppName(): String {
        return appName
    }

    fun getAppDeveloperName(): String {
        return appDeveloperName
    }

    fun getAppVersion(): String {
        return appVersion
    }

    fun getBooks(): List<Book> {
        return bookList
    }

    fun getAveragePrice(): Double {
        return bookList.map { it.price }.average()
    }

    fun getGenreAveragePrice(genre: String): Double {
        val filteredBooks = bookList.filter { it.genre.trim() == genre.trim() }
        return if (filteredBooks.isNotEmpty()) {
            filteredBooks.map { it.price }.average()
        } else {
            0.0
        }
    }
}
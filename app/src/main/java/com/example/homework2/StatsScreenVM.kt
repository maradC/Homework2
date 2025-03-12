package com.example.homework2

import androidx.lifecycle.ViewModel

class StatsScreenVM(private var repository: BookRepository): ViewModel(){

    fun getAveragePrice(): Double {
        return repository.getAveragePrice()
    }

    fun getGenreAveragePrice(genre: String): Double {
        return repository.getGenreAveragePrice(genre)
    }

    fun getGenreStats(): Map<String, Double> {

        val genres = listOf("Average Price", "Biography", "Science Fiction", "Self-help" )
        val stats = mutableMapOf<String, Double>()

        genres.forEach { genre ->
            stats[genre] = getGenreAveragePrice(genre)
        }

        stats["Average Price"] = getAveragePrice()

        return stats
    }
}
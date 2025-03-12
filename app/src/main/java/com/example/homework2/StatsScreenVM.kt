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

        val stats = mutableMapOf<String, Double>()
        stats["Average Price"] = getAveragePrice()

        val genres = listOf( "Biography", "Science Fiction", "Self-help" )

        genres.forEach { genre ->
            stats[genre] = getGenreAveragePrice(genre)
        }

        return stats
    }
}
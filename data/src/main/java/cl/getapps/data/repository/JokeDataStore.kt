package cl.getapps.data.repository

import cl.getapps.data.model.JokeEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for the data operations related to jokes.
 * This is to be implemented by external data source layers, setting the requirements for the
 * operations that need to be implemented
 */
interface JokeDataStore{

    fun clearJokes(): Completable

    fun saveJokes(jokes: List<JokeEntity>): Completable

    fun getJokes(): Single<List<JokeEntity>>
}
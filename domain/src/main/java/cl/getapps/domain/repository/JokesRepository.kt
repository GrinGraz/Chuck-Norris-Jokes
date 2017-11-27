package cl.getapps.domain.repository

import cl.getapps.domain.model.Joke
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface JokesRepository{
    fun clearJokes(): Completable

    fun saveJokes(jokes: List<Joke>): Completable

    fun getJokes(): Single<List<Joke>>
}
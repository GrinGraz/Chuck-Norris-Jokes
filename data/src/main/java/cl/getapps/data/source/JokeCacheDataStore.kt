package cl.getapps.data.source

import cl.getapps.data.model.JokeEntity
import cl.getapps.data.repository.JokeCache
import cl.getapps.data.repository.JokeDataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


open class JokeCacheDataStore
    @Inject constructor(
            private val jokeCache: JokeCache
    ): JokeDataStore{
    override fun clearJokes(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveJokes(jokes: List<JokeEntity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getJokes(): Single<List<JokeEntity>> {
        return jokeCache.getJokes()
    }

}
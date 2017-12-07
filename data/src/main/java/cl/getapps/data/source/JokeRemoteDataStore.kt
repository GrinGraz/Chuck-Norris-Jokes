package cl.getapps.data.source

import cl.getapps.data.model.JokeEntity
import cl.getapps.data.repository.JokeDataStore
import cl.getapps.data.repository.JokeRemote
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


open class JokeRemoteDataStore
    @Inject constructor(private val jokeRemote: JokeRemote): JokeDataStore {

    override fun clearJokes(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveJokes(jokes: List<JokeEntity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun getJokes(): Single<List<JokeEntity>> {
        return jokeRemote.getJokes()
    }

}

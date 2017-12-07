package cl.getapps.data

import cl.getapps.data.mapper.JokeMapper
import cl.getapps.data.model.JokeEntity
import cl.getapps.data.source.JokeDataStoreFactory
import cl.getapps.data.source.JokeRemoteDataStore
import cl.getapps.domain.model.Joke
import cl.getapps.domain.repository.JokesRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


open class JokeDataRepository @Inject constructor(private val factory: JokeDataStoreFactory,
                                                  private val jokeMapper: JokeMapper): JokesRepository{
    override fun clearJokes(): Completable {
        return factory.retrieveCacheDataStore().clearJokes();
    }

    override fun saveJokes(jokes: List<Joke>): Completable {
        val jokeEntities = jokes.map { jokeMapper.mapToEntity(it) }
        return savejokeEntities(jokeEntities)
    }

    private fun savejokeEntities(jokes: List<JokeEntity>): Completable {
        return factory.retrieveCacheDataStore().saveJokes(jokes)
    }

    override fun getJokes(): Single<List<Joke>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getJokes()
                .flatMap {
                    if (dataStore is JokeRemoteDataStore) {
                        savejokeEntities(it).toSingle { it }
                    } else {
                        Single.just(it)
                    }
                }.map { list ->
                    list.map { listItem ->
                        jokeMapper.mapFromEntity(listItem) }
                    }
                }


}
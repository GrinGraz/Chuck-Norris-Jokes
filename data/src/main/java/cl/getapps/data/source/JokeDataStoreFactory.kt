package cl.getapps.data.source

import cl.getapps.data.repository.JokeCache
import cl.getapps.data.repository.JokeDataStore
import javax.inject.Inject

/**
 * Create an instance of a [JokeDataStore]
 */
open class JokeDataStoreFactory @Inject constructor(
        private val jokeCacheDataStore: JokeCacheDataStore,
        private val jokeRemoteDataStore: JokeRemoteDataStore,
        private val jokeCache: JokeCache){
    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): JokeDataStore {
        if (jokeCache.isCached() && !jokeCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveCacheDataStore(): JokeDataStore {
        return jokeCacheDataStore
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveRemoteDataStore(): JokeDataStore {
        return jokeRemoteDataStore
    }
}
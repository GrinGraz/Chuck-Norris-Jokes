package cl.getapps.data.repository

import cl.getapps.data.model.JokeEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for the caching of Jokes. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface JokeCache {

    /**
     * Clear all Jokes from the cache
     */
    fun clearJokes(): Completable

    /**
     * Save a given list of Jokes to the cache
     */
    fun saveJokes(bufferoos: List<JokeEntity>): Completable

    /**
     * Retrieve a list of Jokes, from the cache
     */
    fun getJokes(): Single<List<JokeEntity>>

    /**
     * Checks if an element (User) exists in the cache.

     * @param userId The id used to look for inside the cache.
     * *
     * @return true if the element is cached, otherwise false.
     */
    fun isCached(): Boolean

    /**
     * Checks if an element (User) exists in the cache.

     * @param userId The id used to look for inside the cache.
     * *
     * @return true if the element is cached, otherwise false.
     */
    fun setLastCacheTime(lastCache: Long)

    /**
     * Checks if the cache is expired.

     * @return true, the cache is expired, otherwise false.
     */
    fun isExpired(): Boolean
}
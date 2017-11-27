package cl.getapps.data.repository

import cl.getapps.data.model.JokeEntity
import io.reactivex.Single

/**
 * Interface defining methods for the caching of jokes. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface JokeRemote {
    fun getBufferoos(): Single<List<JokeEntity>>
}
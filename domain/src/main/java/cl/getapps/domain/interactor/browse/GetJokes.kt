package cl.getapps.domain.interactor.browse

import cl.getapps.domain.executor.PostExecutionThread
import cl.getapps.domain.executor.ThreadExecutor
import cl.getapps.domain.interactor.SingleUseCase
import cl.getapps.domain.model.Joke
import cl.getapps.domain.repository.JokesRepository
import io.reactivex.Single
import javax.inject.Inject


open class GetJokes @Inject constructor(val jokesRepository: JokesRepository,
                                        threadExecutor: ThreadExecutor,
                                        postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Joke>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Joke>> {
        return jokesRepository.getJokes()
    }

}

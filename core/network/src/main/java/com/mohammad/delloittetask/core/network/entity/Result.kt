import com.mohammad.delloittetask.core.network.entity.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> result(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline isFetch: (ResultType) -> Boolean = { true }
) = flow {

    val data = query().first()

    val resource = if (isFetch(data)) {

        emit(RequestState.Loading)

        try {
            val resultType = fetch()
            saveFetchResult(resultType)
            query().map { RequestState.Success(it) }

        } catch (exception: Exception) {
            query().map { RequestState.Success(it) }
        }
    } else {
        query().map { RequestState.Success(it) }
    }
    emitAll(resource)
}
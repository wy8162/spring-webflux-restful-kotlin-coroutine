package y.w.hrservice.handler

import kotlinx.coroutines.*
import mu.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.client.*
import org.springframework.web.reactive.function.server.*
import y.w.hrservice.service.*

@Component
class UserCoroutineHandler constructor(val userService: UserCoroutineService,
                                       val webclient: WebClient,
                                       val coroutineScope: CoroutineScope) {
    private val logger = KotlinLogging.logger {}

    suspend fun getUserById(id: String): ServerResponse = ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValueAndAwait(userService.getUserById(id))

    suspend fun getUserByIdDeferred(id: String): ServerResponse {
        logger.info("Call other API /api/controller/user/$id to get the user.")
        val response = coroutineScope.async {
            webclient.get()
                .uri("/api/controller/user/$id")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody<String>()
        }

        return ServerResponse.ok()
            .json()
            .bodyValueAndAwait(response.await())
    }
}
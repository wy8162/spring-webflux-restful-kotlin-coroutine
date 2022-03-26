package y.w.springwebfluxrestfulkotlincoroutine.handler

import kotlinx.coroutines.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.client.*
import org.springframework.web.reactive.function.server.*
import y.w.springwebfluxrestfulkotlincoroutine.model.*
import y.w.springwebfluxrestfulkotlincoroutine.service.*

@Component
class UserCoroutineHandler constructor(val userService: UserCoroutineService, val webclient: WebClient) {
    suspend fun getUserById(id: String): ServerResponse = ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValueAndAwait(userService.getUserById(id))

    suspend fun getUserByIdDeferred(id: String): ServerResponse {
        val response = GlobalScope.async {
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
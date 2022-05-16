package y.w.hrservice.handler

import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.*
import y.w.hrservice.service.*

@Component
class UserHandler constructor(val userService: UserService) {
    fun getUserById(id: String): Mono<ServerResponse> = ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(userService.getUserById(id))
}
package y.w.springwebfluxrestfulkotlincoroutine.controller

import mu.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.*
import y.w.springwebfluxrestfulkotlincoroutine.model.*
import y.w.springwebfluxrestfulkotlincoroutine.service.*

@RestController
@RequestMapping("/api/controller/user")
class UserController(val userService: UserService) {
    private val logger = KotlinLogging.logger {}

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: String): ResponseEntity<Mono<ResponseMessage>> {
        logger.info("Service /api/controller/user being called.")

        val user = userService.getUserById(id)

        return ResponseEntity.ok(Mono.just(ResponseMessage(0, user)))
    }
}
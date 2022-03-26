package y.w.springwebfluxrestfulkotlincoroutine.config

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import org.springdoc.core.annotations.*
import org.springframework.context.annotation.*
import org.springframework.web.reactive.function.server.*
import y.w.springwebfluxrestfulkotlincoroutine.handler.*
import y.w.springwebfluxrestfulkotlincoroutine.model.*

@Configuration
class RouteCoroutineConfiguration constructor(val userHandler: UserCoroutineHandler) {
    @Bean
    @RouterOperations(
        RouterOperation(
            path = "/api/coroutine/user/{id}",
            operation = Operation(
                operationId = "getUserById",
                summary = "Coroutine Functional Endpoint - Get User By Id",
                tags = ["Coroutine Functional Endpoints"],
                parameters = [Parameter(
                    `in` = ParameterIn.PATH,
                    name = "id",
                    description = "User Id"
                )],
                responses = [ApiResponse(
                    responseCode = "200",
                    description = "successful operation",
                    content = [Content(schema = Schema(implementation = User::class))]
                ), ApiResponse(
                    responseCode = "400",
                    description = "Invalid ID supplied"
                ), ApiResponse(responseCode = "404", description = "User not found")]
            )
        ),
        RouterOperation(
            path = "/api/coroutine/user/via/{id}",
            operation = Operation(
                operationId = "getUserByIdDeferred",
                summary = "Coroutine Functional Endpoint, call /api/controller/user/{id} - Get User By Id",
                tags = ["Coroutine Functional Endpoints"],
                parameters = [Parameter(
                    `in` = ParameterIn.PATH,
                    name = "id",
                    description = "User Id"
                )],
                responses = [ApiResponse(
                    responseCode = "200",
                    description = "successful operation",
                    content = [Content(schema = Schema(implementation = User::class))]
                ), ApiResponse(
                    responseCode = "400",
                    description = "Invalid ID supplied"
                ), ApiResponse(responseCode = "404", description = "User not found")]
            )
        )
    )
    fun apiCoroutineRoute() = coRouter {
        ("/api/coroutine/user").nest {
            GET("/{id}") {
                val id = it.pathVariable("id")
                userHandler.getUserById(id)
            }
            GET("/via/{id}") {
                val id = it.pathVariable("id")

                // Call the other service to get a User
                userHandler.getUserByIdDeferred(id)
            }
        }
    }
}
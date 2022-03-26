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
class RouteConfiguration constructor(val userHandler: UserHandler) {
    @Bean
    @RouterOperations(
        RouterOperation(
            path = "/api/func/user/{id}",
            operation = Operation(
                operationId = "getUserById",
                summary = "Functional Endpoint - Get User By Id",
                tags = ["MyAccounts"],
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
    fun apiRoute() = router {
        ("/api/func/user").nest {
            GET("/{id}") {
                val id = it.pathVariable("id")
                userHandler.getUserById(id)
            }
        }
    }
}
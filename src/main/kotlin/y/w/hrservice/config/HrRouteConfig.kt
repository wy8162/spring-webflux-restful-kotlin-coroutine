package y.w.hrservice.config

import org.springframework.context.annotation.*
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RouterFunctions.*
import y.w.hrservice.handler.*

@Configuration
class HrRouteConfig(
    private val employeeHandler: EmployeeHandler
) {
    @Bean
    fun hrServiceRoot(): RouterFunction<ServerResponse> = route()
        .path("/api/v1/employee", this::employeeRoutes)
        .path("/api/v1/job", this::jobRoutes)
        .build()

    private fun employeeRoutes() = coRouter {
        ("/{id}").nest {
            GET("") {
                val id = it.pathVariable("id")
                employeeHandler.getEmployeeById(id.toInt())
            }
        }
    }

    private fun jobRoutes() = coRouter {
        ("/{id}").nest {
            GET("") {
                val id = it.pathVariable("id")
                employeeHandler.getEmployeeById(id.toInt())
            }
        }
    }
}
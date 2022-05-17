package y.w.hrservice.handler

import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.server.*
import y.w.hrservice.error.*
import y.w.hrservice.service.*

@Component
class EmployeeHandler(
    private val employeeService: EmployeeService
) {
    suspend fun getEmployeeById(id: Int): ServerResponse {
        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(employeeService.getEmployeeById(id) ?: throw NotFoundException("Employee does not exist"))
    }
}
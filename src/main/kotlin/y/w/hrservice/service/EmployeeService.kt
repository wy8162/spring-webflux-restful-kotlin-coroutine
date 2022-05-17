package y.w.hrservice.service

import org.springframework.stereotype.Service
import reactor.core.publisher.*
import y.w.hrservice.model.*
import y.w.hrservice.repository.*

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {
    suspend fun getEmployeeById(id: Int): Employee? {
        return employeeRepository.findById(id)
    }
}
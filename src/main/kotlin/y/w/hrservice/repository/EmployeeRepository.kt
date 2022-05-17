package y.w.hrservice.repository

import org.springframework.data.repository.kotlin.*
import y.w.hrservice.model.*

interface EmployeeRepository : CoroutineCrudRepository<Employee, Int>
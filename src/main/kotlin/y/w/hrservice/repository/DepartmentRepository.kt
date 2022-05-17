package y.w.hrservice.repository

import org.springframework.data.repository.kotlin.*
import y.w.hrservice.model.*

interface DepartmentRepository: CoroutineCrudRepository<Department, Int>
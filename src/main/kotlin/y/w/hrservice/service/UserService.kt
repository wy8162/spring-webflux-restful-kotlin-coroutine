package y.w.hrservice.service

import org.springframework.stereotype.Service
import y.w.hrservice.model.*

@Service
class UserService {
    fun getUserById(id: String): User = User(id, "Yang", "Wang")
}
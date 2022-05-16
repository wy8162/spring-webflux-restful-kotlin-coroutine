package y.w.hrservice.service

import org.springframework.stereotype.Service
import y.w.hrservice.model.*

@Service
class UserCoroutineService {
    suspend fun getUserById(id: String): User = User(id, "Yang", "Wang")
}
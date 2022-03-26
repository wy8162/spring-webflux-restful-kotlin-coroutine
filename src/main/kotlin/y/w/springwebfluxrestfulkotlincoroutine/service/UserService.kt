package y.w.springwebfluxrestfulkotlincoroutine.service

import org.springframework.stereotype.Service
import y.w.springwebfluxrestfulkotlincoroutine.model.*

@Service
class UserService {
    fun getUserById(id: String): User = User(id, "Yang", "Wang")
}
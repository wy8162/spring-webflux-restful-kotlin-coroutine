package y.w.springwebfluxrestfulkotlincoroutine.model

data class User(val id: String, val firstName: String, val lastName: String)
data class ResponseMessage(val errorCode: Int, val user: User?)

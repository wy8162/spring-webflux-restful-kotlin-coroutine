package y.w.hrservice.model

data class ResponseMessage<T>(val errorCode: Int, val user: T?)

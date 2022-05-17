package y.w.hrservice.error

import mu.*
import org.springframework.boot.autoconfigure.web.*
import org.springframework.boot.autoconfigure.web.reactive.error.*
import org.springframework.boot.web.error.*
import org.springframework.boot.web.reactive.error.*
import org.springframework.context.*
import org.springframework.core.annotation.*
import org.springframework.http.*
import org.springframework.http.codec.*
import org.springframework.stereotype.*
import org.springframework.web.reactive.function.server.*

@Component
@Order(-2)
class GlobalExceptionHandler(
    errorAttributes: ErrorAttributes,
    applicationContext: ApplicationContext,
    serverCodecConfigurer: ServerCodecConfigurer
) : AbstractErrorWebExceptionHandler(errorAttributes, WebProperties.Resources(), applicationContext) {

    companion object {
        private val logger = KotlinLogging.logger {}
        private const val HTTP_STATUS_KEY = "status"
        private const val MESSAGE_KEY = "message"
        private const val ERRORS_KEY = "error"
    }

    init {
        setMessageWriters(serverCodecConfigurer.writers)
    }

    override fun setMessageWriters(messageWriters: MutableList<HttpMessageWriter<*>>?) {
        super.setMessageWriters(messageWriters)
    }

    override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> {
        return RouterFunctions.route({ true }) { request ->
            val error: Throwable = getError(request)
            val attrs = getErrorAttributes(request, ErrorAttributeOptions.defaults())
            attrs[ERRORS_KEY] = error.message

            when (error) {
                is NotFoundException -> {
                    attrs[HTTP_STATUS_KEY] = HttpStatus.NOT_FOUND
                    ServerResponse
                        .status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(attrs)
                }
                else -> {
                    attrs[HTTP_STATUS_KEY] = HttpStatus.BAD_REQUEST
                    ServerResponse
                        .badRequest()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(attrs)
                }
            }

        }
    }
}
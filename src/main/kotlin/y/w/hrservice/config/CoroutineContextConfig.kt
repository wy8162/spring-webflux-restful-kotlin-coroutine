package y.w.hrservice.config

import kotlinx.coroutines.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoroutineContextConfig {
    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println(coroutineContext)
        println(throwable.message)
    }

    @Bean
    fun topCoroutineScope(): CoroutineScope = CoroutineScope(
        CoroutineName("API Top Coroutine Context")
                + Job()
                + Dispatchers.IO
                + coroutineExceptionHandler)
}
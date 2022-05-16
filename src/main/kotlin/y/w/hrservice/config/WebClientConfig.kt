package y.w.hrservice.config

import org.springframework.context.annotation.*
import org.springframework.http.client.reactive.*
import org.springframework.web.reactive.function.client.*
import reactor.netty.http.client.*

@Configuration
class WebClientConfig {
    @Bean
    fun webClient(): WebClient {
        val httpClient = HttpClient.create()
        return WebClient
            .builder()
            .baseUrl("http://localhost:8080")
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .build()
    }
}
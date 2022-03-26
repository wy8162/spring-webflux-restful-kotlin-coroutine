package y.w.springwebfluxrestfulkotlincoroutine.config

import io.swagger.v3.oas.models.*
import io.swagger.v3.oas.models.info.*
import org.springframework.context.annotation.*
import org.springframework.stereotype.*

@Component
class OpenAPIConfig {
    @Bean
    fun openApiDoc(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                Info()
                .title("Webflux Practice API")
                .description("Demonstration of Reactive REST service with controller, Functional Route and Coroutine Functional Route.")
                .version("1.6.6")
                .license(License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(Contact()
                    .name("WYANG")
                    .url("https://github.com/wy8162")
                    .email("wy8162@gmail.com")));
    }
}
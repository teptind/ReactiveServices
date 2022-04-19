package info.teptind.reactiveservices.exceptions

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Configuration
@Order(-3)
class GlobalErrorHandler(private val objectMapper: ObjectMapper) : ErrorWebExceptionHandler {

    override fun handle(serverWebExchange: ServerWebExchange, throwable: Throwable): Mono<Void> {
        val bufferFactory = serverWebExchange.response.bufferFactory()

        serverWebExchange.response.statusCode = HttpStatus.BAD_REQUEST
        val dataBuffer = bufferFactory.wrap(objectMapper.writeValueAsBytes(HttpError(throwable.message)))
        serverWebExchange.response.headers.contentType = MediaType.APPLICATION_JSON

        return serverWebExchange.response.writeWith(Mono.just(dataBuffer))
    }

    data class HttpError(val message: String?)
}
package info.teptind.reactiveservices.repository

import info.teptind.reactiveservices.model.Currency
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface CurrencyRepository: ReactiveCrudRepository<Currency, String> {

    fun findByName(name: String): Mono<Currency>

    fun existsByName(name: String): Mono<Boolean>

}
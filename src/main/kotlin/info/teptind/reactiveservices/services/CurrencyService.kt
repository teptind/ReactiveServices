package info.teptind.reactiveservices.services

import info.teptind.reactiveservices.exceptions.CurrencyNotFoundException
import info.teptind.reactiveservices.model.Currency
import info.teptind.reactiveservices.repository.CurrencyRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class CurrencyService(
    val currencyRepository: CurrencyRepository
) {

    fun create(name: String, usdEq: Double): Mono<Void> {
         return currencyRepository.save(Currency(name, usdEq)).then()
    }

    fun getCurrency(name: String): Mono<Currency> {
        return currencyRepository.findByName(name)
            .switchIfEmpty { Mono.error { CurrencyNotFoundException(name) } }
    }

}
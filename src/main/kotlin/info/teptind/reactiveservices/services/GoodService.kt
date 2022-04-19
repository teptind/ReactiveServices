package info.teptind.reactiveservices.services

import info.teptind.reactiveservices.model.Good
import info.teptind.reactiveservices.repository.GoodRepository
import info.teptind.reactiveservices.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class GoodService(
    val goodRepository: GoodRepository
) {

    fun createGood(price: Double, name: String): Mono<UUID> {
        return goodRepository.save(Good(UUID.randomUUID(), price, name))
            .map { it.id }
    }
}
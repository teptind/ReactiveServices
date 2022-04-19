package info.teptind.reactiveservices.services

import info.teptind.reactiveservices.model.Currency
import info.teptind.reactiveservices.repository.GoodRepository
import info.teptind.reactiveservices.view.GoodView
import info.teptind.reactiveservices.view.GoodViewMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class StorageService(
    val goodRepository: GoodRepository,
    val currencyService: CurrencyService,
    val goodViewMapper: GoodViewMapper,
    val userService: UserService
) {

    fun viewForUser(userId: UUID): Flux<GoodView> {
        return userService.getUser(userId)
            .flatMap { user -> currencyService.getCurrency(user.currencyName) }
            .flatMapMany { currencyRate -> mapGoodWithRate(currencyRate) }
    }

    private fun mapGoodWithRate(currencyRate: Currency) =
        goodRepository.findAll().map { good -> goodViewMapper.toViewWithAnotherRate(good, currencyRate.usdEq) }

}
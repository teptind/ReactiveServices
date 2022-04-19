package info.teptind.reactiveservices.controllers

import info.teptind.reactiveservices.services.StorageService
import info.teptind.reactiveservices.services.GoodService
import info.teptind.reactiveservices.view.GoodView
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/api/goods")
class GoodsController(
    val storageService: StorageService,
    val goodService: GoodService,
) {

    @PostMapping
    fun create(@RequestParam price: Double, @RequestParam name: String): Mono<UUID> {
        return goodService.createGood(price, name)
    }

    @GetMapping("/all/user/{userId}")
    fun getAssortment(@PathVariable userId: UUID): Flux<GoodView> {
        return storageService.viewForUser(userId)
    }

}
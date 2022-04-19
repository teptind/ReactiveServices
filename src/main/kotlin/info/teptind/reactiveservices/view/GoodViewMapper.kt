package info.teptind.reactiveservices.view

import info.teptind.reactiveservices.model.Good
import org.springframework.stereotype.Component

@Component
class GoodViewMapper {

    fun toViewWithAnotherRate(good: Good, rate: Double): GoodView = GoodView(
            id = good.id,
            name = good.name,
            price = good.price * rate
        )
}
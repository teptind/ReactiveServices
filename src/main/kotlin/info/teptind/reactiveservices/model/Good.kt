package info.teptind.reactiveservices.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Good(
    @Id
    val id: UUID,
    val price: Double,
    val name: String
)
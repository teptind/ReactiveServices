package info.teptind.reactiveservices.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document
data class User(
    @Id
    val id: UUID,
    val currencyName: String
)
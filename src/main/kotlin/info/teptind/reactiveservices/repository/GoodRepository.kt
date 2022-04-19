package info.teptind.reactiveservices.repository

import info.teptind.reactiveservices.model.Good
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface GoodRepository: ReactiveCrudRepository<Good, UUID>
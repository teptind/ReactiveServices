package info.teptind.reactiveservices.repository

import info.teptind.reactiveservices.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

interface UserRepository : ReactiveCrudRepository<User, UUID>
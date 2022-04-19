package info.teptind.reactiveservices.exceptions

import java.util.UUID

class UserNotFoundException(id: UUID): Exception("User with id $id is not found")
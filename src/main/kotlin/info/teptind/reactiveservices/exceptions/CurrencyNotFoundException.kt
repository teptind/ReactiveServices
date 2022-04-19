package info.teptind.reactiveservices.exceptions

class CurrencyNotFoundException(string: String) : Exception("Currency $string is not found")
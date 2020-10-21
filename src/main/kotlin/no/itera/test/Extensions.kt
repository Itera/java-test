package no.itera.test

import java.util.*

// Allows conversion of Optional<T> to T?
fun <T> Optional<T>.unwrap(): T? = orElse(null)

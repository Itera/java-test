package com.itera.test

import java.util.Optional

// Allows conversion of Optional<T> to T?
fun <T> Optional<T>.unwrap(): T? = orElse(null)

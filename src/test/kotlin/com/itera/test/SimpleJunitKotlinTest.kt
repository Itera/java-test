package com.itera.test

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SimpleJunitKotlinTest {
    @Test
    fun `test the business logic`() {
        // Business logic
        val result = 3 + 2

        // Test
        result shouldBe 5
    }
}

package no.itera.test.repository

import org.springframework.stereotype.Component

interface KotlinRepository {
    fun isUp(): Boolean
}

@Component
class DummyKotlinRepository : KotlinRepository {
    override fun isUp() = true
}

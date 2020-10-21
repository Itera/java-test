package no.itera.test.repository

import org.springframework.stereotype.Component

interface DummyKotlinRepository {
    fun isUp(): Boolean
}

@Component
class DummyKotlinRepositoryImpl : DummyKotlinRepository {
    override fun isUp() = true
}

package no.itera.test.service

import no.itera.test.repository.DummyKotlinRepository
import org.springframework.stereotype.Service

@Service
class DummyKotlinService(val repository: DummyKotlinRepository) {
    fun backendCheck() = repository.isUp()
}

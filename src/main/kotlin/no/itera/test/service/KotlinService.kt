package no.itera.test.service

import no.itera.test.repository.KotlinRepository
import org.springframework.stereotype.Service

@Service
class KotlinService(val repository: KotlinRepository) {
    fun backendCheck() = repository.isUp()

}

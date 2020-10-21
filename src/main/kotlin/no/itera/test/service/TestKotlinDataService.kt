package no.itera.test.service

import no.itera.test.domain.DataNotFoundException
import no.itera.test.repository.TestKotlinDataRepository
import no.itera.test.unwrap
import org.springframework.stereotype.Service

@Service
class TestKotlinDataService(val repository: TestKotlinDataRepository) {
    fun getAll() = repository.findAll().toList()

    fun getById(id: Long) = repository.findById(id).unwrap() ?: throw DataNotFoundException()
}

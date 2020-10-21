package no.itera.test.service

import no.itera.test.domain.DataNotFoundException
import no.itera.test.repository.DataKotlinRepository
import no.itera.test.unwrap
import org.springframework.stereotype.Service

@Service
class DataKotlinService(val repository: DataKotlinRepository) {
    fun getAll() = repository.findAll().toList()

    fun getData(id: Long) = repository.findById(id).unwrap() ?: throw DataNotFoundException()
}

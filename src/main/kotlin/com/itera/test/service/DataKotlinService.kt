package com.itera.test.service

import com.itera.test.domain.DataNotFoundException
import com.itera.test.repository.DataKotlinRepository
import com.itera.test.unwrap
import org.springframework.stereotype.Service

@Service
class DataKotlinService(val repository: DataKotlinRepository) {
    fun getAll() = repository.findAll().toList()

    fun getData(id: Long) = repository.findById(id).unwrap() ?: throw DataNotFoundException()
}

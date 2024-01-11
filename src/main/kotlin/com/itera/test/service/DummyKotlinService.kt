package com.itera.test.service

import com.itera.test.repository.DummyKotlinRepository
import org.springframework.stereotype.Service

@Service
class DummyKotlinService(val repository: DummyKotlinRepository) {
    fun backendCheck() = repository.isUp()
}

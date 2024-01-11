package com.itera.test

import com.itera.test.repository.DataKotlinRepository
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
open class DataKotlinRepositoryIT {
    @Autowired
    private lateinit var repository: DataKotlinRepository

    @Test
    fun dataWasLoaded() {
        val items = repository.findAll()

        items.size shouldBe 5
    }
}

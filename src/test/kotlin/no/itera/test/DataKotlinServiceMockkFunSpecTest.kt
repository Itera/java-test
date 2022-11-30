package no.itera.test

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import no.itera.test.domain.DataKotlin
import no.itera.test.domain.DataNotFoundException
import no.itera.test.repository.DataKotlinRepository
import no.itera.test.service.DataKotlinService
import java.util.*

class DataKotlinServiceMockkFunSpecTest : FunSpec({
    val repository = mockk<DataKotlinRepository>()

    afterTest {
        clearMocks(repository)
    }

    test("get all") {
        every { repository.findAll() } returns listOf()

        val service = DataKotlinService(repository)

        service.getAll() shouldBe listOf<DataKotlin>()

        verify(exactly = 1) { repository.findAll() }
    }

    test("get single") {
        val slot = slot<Long>()

        every { repository.findById(capture(slot)) } returns Optional.of(DataKotlin(1, ""))

        val service = DataKotlinService(repository)

        service.getData(1) shouldBe DataKotlin(1, "")

        verify(exactly = 1) { repository.findById(any()) }

        slot.captured shouldBe 1
    }

    test("get single no hit") {
        every { repository.findById(any()) } returns Optional.empty()

        val service = DataKotlinService(repository)

        shouldThrow<DataNotFoundException> {
            service.getData(1)
        }

        verify(exactly = 1) { repository.findById(any()) }
    }
})

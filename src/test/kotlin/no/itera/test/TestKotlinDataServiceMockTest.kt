package no.itera.test

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import no.itera.test.domain.DataNotFoundException
import no.itera.test.domain.TestKotlinData
import no.itera.test.repository.DummyRepository
import no.itera.test.repository.TestKotlinDataRepository
import no.itera.test.service.JavaService
import no.itera.test.service.TestKotlinDataService
import java.util.*

class TestKotlinDataServiceMockTest : FunSpec({
    val repository = mockk<TestKotlinDataRepository>()

    afterTest {
        clearMocks(repository)
    }

    test("get all") {
        every { repository.findAll() } returns listOf()

        val service = TestKotlinDataService(repository)

        service.getAll() shouldBe listOf<TestKotlinData>()

        verify(exactly = 1) { repository.findAll() }
    }

    test("get single") {
        val slot = slot<Long>()

        every { repository.findById(capture(slot)) } returns Optional.of(TestKotlinData(1, ""))

        val service = TestKotlinDataService(repository)

        service.getById(1) shouldBe TestKotlinData(1, "")

        verify(exactly = 1) { repository.findById(any()) }

        slot.captured shouldBe 1
    }


    test("get single no hit") {
        every { repository.findById(any()) } returns Optional.empty()

        val service = TestKotlinDataService(repository)

        shouldThrow<DataNotFoundException> {
            service.getById(1)
        }

        verify(exactly = 1) { repository.findById(any()) }
    }
})

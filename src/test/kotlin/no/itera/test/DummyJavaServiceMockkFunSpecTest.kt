package no.itera.test

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import no.itera.test.repository.DummyRepository
import no.itera.test.service.DummyJavaService

class DummyJavaServiceMockkFunSpecTest : FunSpec({
    val repository = mockk<DummyRepository>()

    afterTest {
        clearMocks(repository)
    }

    test("status check") {
        every { repository.isUp } returns true

        val service = DummyJavaService(repository)

        service.backendCheck() shouldBe true

        verify(exactly = 1) { repository.isUp }
    }

    test("status check fails") {
        every { repository.isUp } returns false

        val service = DummyJavaService(repository)

        service.backendCheck() shouldBe false

        verify(exactly = 1) { repository.isUp }
    }

})

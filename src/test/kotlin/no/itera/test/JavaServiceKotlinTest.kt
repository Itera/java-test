package no.itera.test

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe
import no.itera.test.repository.FakeRepository
import no.itera.test.service.JavaService

class JavaServiceKotlinTest : FunSpec() {
    private lateinit var service: JavaService

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        service = JavaService(FakeRepository())
    }

    init {
        test("test calculation") {
            service.complexCalculation(2, 4) shouldBe 6
            service.complexCalculation(1, 9) shouldBe 10
            service.complexCalculation(-2, 4) shouldBe 2
        }
    }
}

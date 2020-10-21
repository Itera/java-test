package no.itera.test

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe
import no.itera.test.repository.DummyRepositoryImpl
import no.itera.test.service.DummyJavaService

class DummyJavaServiceFunSpec : FunSpec() {
    private lateinit var service: DummyJavaService

    override fun beforeTest(testCase: TestCase) {
        super.beforeTest(testCase)
        service = DummyJavaService(DummyRepositoryImpl())
    }

    init {
        test("test calculation") {
            service.complexCalculation(2, 4) shouldBe 6
            service.complexCalculation(1, 9) shouldBe 10
            service.complexCalculation(-2, 4) shouldBe 2
        }
    }
}

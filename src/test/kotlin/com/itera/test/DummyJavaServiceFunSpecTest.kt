package com.itera.test

import com.itera.test.repository.DummyRepositoryImpl
import com.itera.test.service.DummyJavaService
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

class DummyJavaServiceFunSpecTest : FunSpec() {
    private lateinit var service: DummyJavaService

    override suspend fun beforeTest(testCase: TestCase) {
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

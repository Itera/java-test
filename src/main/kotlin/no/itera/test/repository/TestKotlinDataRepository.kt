package no.itera.test.repository

import no.itera.test.domain.TestKotlinData
import org.springframework.data.jpa.repository.JpaRepository

interface TestKotlinDataRepository : JpaRepository<TestKotlinData, Long>

package no.itera.test.repository

import no.itera.test.domain.DataKotlin
import org.springframework.data.jpa.repository.JpaRepository

interface DataKotlinRepository : JpaRepository<DataKotlin, Long>

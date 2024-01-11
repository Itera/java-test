package com.itera.test.repository

import com.itera.test.domain.DataKotlin
import org.springframework.data.jpa.repository.JpaRepository

interface DataKotlinRepository : JpaRepository<DataKotlin, Long>

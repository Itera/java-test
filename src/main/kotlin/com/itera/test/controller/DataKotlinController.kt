package com.itera.test.controller

import com.itera.test.service.DataKotlinService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlinData")
class DataKotlinController(val service: DataKotlinService) {
    @RequestMapping("/")
    fun getAll() = service.getAll()

    @RequestMapping("/{id}/")
    fun getById(
        @PathVariable id: String,
    ) = service.getData(id.toLong())
}

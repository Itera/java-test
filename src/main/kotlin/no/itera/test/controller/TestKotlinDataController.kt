package no.itera.test.controller

import no.itera.test.service.TestKotlinDataService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/testkotlindata")
class TestKotlinDataController(val service: TestKotlinDataService) {
    @RequestMapping("/")
    fun getAll() = service.getAll()

    @RequestMapping("/{id}/")
    fun getById(@PathVariable id: String) = service.getById(id.toLong())
}

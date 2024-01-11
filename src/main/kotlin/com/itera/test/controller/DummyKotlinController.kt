package com.itera.test.controller

import com.itera.test.service.DummyKotlinService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin")
class DummyKotlinController(val service: DummyKotlinService) {

    @RequestMapping("/")
    fun healthCheck() = if (service.backendCheck()) {
        "OK"
    } else {
        "Not OK"
    }
}

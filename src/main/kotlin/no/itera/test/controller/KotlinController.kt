package no.itera.test.controller

import no.itera.test.service.KotlinService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin")
class KotlinController(val service: KotlinService) {

    @RequestMapping("/")
    fun healthCheck() = if (service.backendCheck()) {
        "OK"
    } else {
        "Not OK"
    }
}

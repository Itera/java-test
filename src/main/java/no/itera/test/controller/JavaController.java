package no.itera.test.controller;

import no.itera.test.service.JavaService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class JavaController {
  private final JavaService service;

  public JavaController(JavaService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public String healthCheck() {
    if (service.backendCheck()) {
      return "OK";
    } else {
      return "Not OK";
    }
  }
}

package no.itera.test.controller;

import no.itera.test.service.DummyJavaService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class DummyJavaController {
  private final DummyJavaService service;

  public DummyJavaController(DummyJavaService service) {
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

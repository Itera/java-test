package no.itera.test.controller;

import java.util.List;
import java.util.Optional;

import no.itera.test.domain.DataNotFoundException;
import no.itera.test.domain.DataJava;
import no.itera.test.service.DataJavaService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/javaData")
public class DataJavaController {
  private final DataJavaService service;

  public DataJavaController(DataJavaService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public List<DataJava> getAll() {
    return service.allData();
  }

  @RequestMapping("/{id}/")
  public DataJava getById(@PathVariable String id) {
    Optional<DataJava> data = service.getData(Long.valueOf(id));

    return data.orElseThrow(DataNotFoundException::new);
  }
}

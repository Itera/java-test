package no.itera.test.controller;

import java.util.List;
import java.util.Optional;

import no.itera.test.domain.DataNotFoundException;
import no.itera.test.domain.TestData;
import no.itera.test.service.TestDataService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testdata")
public class TestDataController {
  private final TestDataService service;

  public TestDataController(TestDataService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public List<TestData> getAll() {
    return service.allData();
  }

  @RequestMapping("/{id}/")
  public TestData getById(@PathVariable String id) {
    Optional<TestData> data = service.getData(Long.valueOf(id));

    return data.orElseThrow(DataNotFoundException::new);
  }
}

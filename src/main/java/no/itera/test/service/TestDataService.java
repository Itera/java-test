package no.itera.test.service;

import java.util.List;
import java.util.Optional;

import no.itera.test.domain.TestData;
import no.itera.test.repository.TestDataRepository;

import org.springframework.stereotype.Service;

@Service
public class TestDataService {
  private final TestDataRepository repository;

  public TestDataService(TestDataRepository repository) {
    this.repository = repository;
  }

  public List<TestData> allData() {
    return repository.findAll();
  }

  public Optional<TestData> getData(long id) {
    return repository.findById(id);
  }
}

package no.itera.test.service;

import no.itera.test.repository.DummyRepository;

import org.springframework.stereotype.Service;

@Service
public class DummyJavaService {

  private final DummyRepository repository;

  public DummyJavaService(DummyRepository repository) {
    this.repository = repository;
  }

  public boolean backendCheck() {
    return repository.isUp();
  }

  public int complexCalculation(int a, int b) {
    return a + b;
  }
}

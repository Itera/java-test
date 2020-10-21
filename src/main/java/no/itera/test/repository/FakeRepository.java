package no.itera.test.repository;

import org.springframework.stereotype.Component;

@Component
public class FakeRepository implements DummyRepository {
  @Override
  public boolean isUp() {
    return true;
  }
}
